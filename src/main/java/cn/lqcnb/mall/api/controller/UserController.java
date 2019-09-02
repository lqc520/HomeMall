package cn.lqcnb.mall.api.controller;

import cn.lqcnb.mall.api.entity.Member;
import cn.lqcnb.mall.api.entity.User;
import cn.lqcnb.mall.api.service.UserService;
import cn.lqcnb.mall.common.entity.R;
import cn.lqcnb.mall.common.utils.TencentSMSUtils.SMSUtils;
import cn.lqcnb.mall.common.utils.TokenUtil;
import cn.lqcnb.mall.common.utils.redisUtils.RedisSMSUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Author: Lin QiCheng
 * Date: 2019/8/30 10:32
 * To change this template use File | Settings | File Templates.
 * Description:
 * Modify by:
 */
@RestController
@Api(tags = "后台管理")
@CrossOrigin
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisSMSUtil redisSMSUtil;
    @Autowired
    private HttpSession session;


    @GetMapping("req")
    @ApiOperation("注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user" ,value = "用户对象",paramType="query"),
            @ApiImplicitParam(name = "code" ,value = "验证码",paramType="query",required = true)
    })
    public R req(User user,String code){
        String SMSCode = redisSMSUtil.getCode(user.getMobile());
        if(code.equals(SMSCode)){
            if(userService.add(user)){
                return R.ok("注册成功");
            }
            return R.error();

        }else{
            return R.error("验证码错误");
        }
    }


    @GetMapping("reset")
    @ApiOperation("重置验证")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile" ,value = "手机号",paramType="query",required = true),
//            @ApiImplicitParam(name = "password" ,value = "密码",paramType="query",required = true),
            @ApiImplicitParam(name = "code" ,value = "验证码",paramType="query",required = true)
    })
    public R reset(String mobile,String code){
        String SMSCode = redisSMSUtil.getCode(mobile);
        if(code.equals(SMSCode)){
            session.setAttribute("mobile",mobile);
            return R.ok();
        }
        return R.error("验证码错误");
    }


    @GetMapping("resetPwd")
    @ApiOperation("重置密码")
    @ApiImplicitParam(name = "password" ,value = "密码",paramType="query",required = true)
    public R resetPwd(String password){
        String mobile = session.getAttribute("mobile").toString();
        User params = new User();
        params.setMobile(mobile);
        User user = userService.findOne(params);
        if(user!=null){
            params.setPassword(password);
            if(userService.updateByMobile(params)){
                return R.ok();
            }
            return R.error();
        }
        return R.error("验证码错误");
    }



    @PostMapping("updatePwd")
    @ApiOperation("修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "oldPassword" ,value = "旧密码",paramType="query",required = true),
            @ApiImplicitParam(name = "password" ,value = "新密码",paramType="query",required = true)
    })
    public R updatePwd(String oldPassword,String password){

        User params = new User();
        params.setPassword(password);
        if(userService.updateByPassword(params, oldPassword)){
            return R.ok();
        }
        return R.error();
    }



    @GetMapping("info")
    @ApiOperation("获取用户信息")
    public R getInfo(){
        User admin = (User) session.getAttribute("admin");
        if(admin!=null){
            return R.ok(admin);
        }
        return R.error();
    }



    @GetMapping("logout")
    @ApiOperation("退出登录")
    public R logout(){
       session.removeAttribute("admin");
       return R.ok();
    }



    @GetMapping("login")
    @ApiOperation("登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile" ,value = "手机号",paramType="query",required = true),
            @ApiImplicitParam(name = "password" ,value = "密码",paramType="query",required = true)
    })
    public R login(String mobile,String password){
        User params = new User();
        params.setMobile(mobile);
        params.setPassword(password);
        User user = userService.findOne(params);
        if(user!=null){
            String adminToken = TokenUtil.getAdminToken(user);
            session.setAttribute("admin",user);
            return R.ok("登录成功",adminToken);
        }
        return R.error();
    }


    @ApiOperation(value = "检测手机号是否注册")
    @ApiImplicitParam(name = "mobile" ,value = "手机号",paramType="path")
    @GetMapping("checkMobile/{mobile}")
    public R checkMobile(@PathVariable String mobile){
        User params = new User();
        params.setMobile(mobile);
        User one = userService.findOne(params);
        if(one==null){
            return R.error("您的手机号未注册 将进行注册");
        }else{
            return R.ok();
        }
    }


    @ApiOperation(value = "获取腾讯云短信注册验证码")
    @ApiImplicitParam(name = "mobile" ,value = "手机号",paramType="path",required = true)
    @GetMapping("getRegisterCode/{mobile}")
    public R getRegisterCode(@PathVariable String mobile){
        String code = SMSUtils.getRegisterCode(mobile);
        if (code!=null){
            redisSMSUtil.setCodeTime(mobile,code,300);
            return R.ok("验证码已发送 5分钟内有效",code);
        }
        return R.error("获取短信验证码错误");
    }


    @ApiOperation(value = "获取腾讯云短信登录验证码")
    @ApiImplicitParam(name = "mobile" ,value = "手机号",paramType="path",required = true)
    @GetMapping("getLoginCode/{mobile}")
    public R getLoginCode(@PathVariable String mobile){
        String code = SMSUtils.getLoginCode(mobile);
        if (code!=null){
            redisSMSUtil.setCodeTime(mobile,code,300);
            return R.ok("验证码已发送 5分钟内有效",code);
        }
        return R.error("获取短信验证码错误");
    }


    @ApiOperation(value = "获取腾讯云短信重置验证码")
    @ApiImplicitParam(name = "mobile" ,value = "手机号",paramType="path",required = true)
    @GetMapping("getResetCode/{mobile}")
    public R getResetCode(@PathVariable String mobile){
        String code = SMSUtils.getReSetCode(mobile);
        if (code!=null){
            redisSMSUtil.setCodeTime(mobile,code,300);
            return R.ok("验证码已发送 5分钟内有效",code);
        }
        return R.error("获取短信验证码错误");
    }


}

package cn.lqcnb.mall.api.controller;

import cn.lqcnb.mall.api.annotation.PassToken;
import cn.lqcnb.mall.api.annotation.UserLoginToken;
import cn.lqcnb.mall.api.entity.Card;
import cn.lqcnb.mall.api.entity.Member;
import cn.lqcnb.mall.api.service.CardService;
import cn.lqcnb.mall.api.service.MemberService;
import cn.lqcnb.mall.common.entity.R;
import cn.lqcnb.mall.common.utils.TencentSMSUtils.SMSUtils;
import cn.lqcnb.mall.common.utils.TokenUtil;
import cn.lqcnb.mall.common.utils.redisUtils.RedisSMSUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * Author: Lin QiCheng
 * Date: 2019/8/25 11:34
 * To change this template use File | Settings | File Templates.
 * Description:
 * Modify by:
 */

@RestController
@Api(tags = "用户管理")
@CrossOrigin
@RequestMapping("api/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private RedisSMSUtil redisSMSUtil;
    @Autowired
    private CardService cardService;

    @PassToken
    @ApiOperation(value = "登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile" ,value = "手机号",paramType="query",required = true),
            @ApiImplicitParam(name = "code" ,value = "验证码",paramType="query",required = true)
    })
    @PostMapping("login")
    public R login(String mobile, String code, @CookieValue(required = false) String cards,@ApiParam(hidden =true) HttpServletResponse response){
        String SMSCode = redisSMSUtil.getCode(mobile);
        if(code.equals(SMSCode)){
            Member user = memberService.findOne(new Member(mobile));
            if(user!=null){//登录成功
                if(!StringUtils.isEmpty(cards)){//前台购物车有商品
                    //解析数据 获取商品id和数量
                    List<Card> maps = JSONArray.parseObject(cards, new TypeReference<List<Card>>() {
                    });
                    String ids="",nums="";
                    System.out.println(maps);
                    for (Card m : maps){
                        ids += m.getGoodsId()+",";//goodsId
                        nums += m.getNumber().toString()+",";  //number
                    }
                    // 从数据库查询商品信息 通过id获取商品数据
                    List<Card> cardsList = cardService.getCards(ids.split(","));
                    //System.out.println(cardsList);
                    int i=0;
                    String[] num = nums.split(",");
                    //修改商品的数量

                    for (Card card : cardsList){
                        //为什么这么麻烦 前台导致
                        card.setNumber(String.valueOf(Integer.parseInt(num[i])<card.getStock()?Integer.parseInt(num[i]):card.getStock()));//商品数量 检测库存
                        card.setMemberId(user.getId());

                        //查询前台购物车商品是否在数据库里面 购物车有这个id???
                        Card cheGoods= new Card();
                        cheGoods.setGoodsId(card.getGoodsId());
                        Card checkGood = cardService.findOne(cheGoods);

                        //在数据查询到商品  修改为当前数据库商品数量
                        if(checkGood!=null){
                            if(checkGood.getNumber()!=card.getNumber()){//商品数量不一致才修改
                                Card upt = new Card();
                                upt.setId(checkGood.getId());
//                            upt.setNumber(String.valueOf(Integer.parseInt(num[i])+Integer.parseInt(checkGood.getNumber()) <card.getStock()? Integer.parseInt(num[i])+Integer.parseInt(checkGood.getNumber()):card.getStock()));
                                upt.setNumber(String.valueOf(Integer.parseInt(checkGood.getNumber()) <card.getStock()? Integer.parseInt(checkGood.getNumber()):card.getStock()));
                                cardService.update(upt);
                            }

                        }else{ //没有添加
                            //数据库环节 后期改redis
                            card.setStock(null);
                            cardService.add(card);


                        }

                        i++;
                    }
                    System.out.println("cardsList:"+cardsList);
                    //更新前台cookie购物车 为当前数据库最新数据
                    Card params =new Card();
                    params.setMemberId(user.getId());
                    List<Card> updateCookie = cardService.findList(params);

                    System.out.println(JSONArray.toJSONString(updateCookie));
                    try {
                        String encode = URLEncoder.encode(JSONArray.toJSONString(updateCookie), "UTF-8");
                        Cookie newCard = new Cookie("cards", encode);
                        newCard.setPath("/");
                        newCard.setMaxAge(60 * 60 * 24 * 7);
                        response.addCookie(newCard);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }

                }
//                session.setAttribute("user", JSON.toJSON(user));
                //测试放回数据 上线关闭
                String token= TokenUtil.getToken(user);
                JSONObject jsonUser = new JSONObject();
                jsonUser.put("user",user);
                jsonUser.put("token",token);
                //添加cookie
                Cookie tokenCookie = new Cookie("token",token);
                tokenCookie.setMaxAge(7 * 24 * 60 * 60);
                tokenCookie.setPath("/");
                //tokenCookie.setDomain("mall.lqcnb.cn");
                response.addCookie(tokenCookie);
                //不需要userId 在Token取
                Cookie userId = new Cookie("userId",user.getId().toString());
//                userId.setMaxAge(7 * 24 * 60 * 60);
                userId.setPath("/");
                response.addCookie(userId);
                return R.ok("登录成功",jsonUser);
            }else{
                return R.error("请先注册");
            }

        }else{
            return R.error("验证码错误");
        }
    }


    @ApiOperation(value = "注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile" ,value = "手机号",paramType="query",required = true),
            @ApiImplicitParam(name = "code" ,value = "验证码",paramType="query",required = true)
    })
    @PostMapping("register")
    public R register(String mobile,String code){

        String SMSCode = redisSMSUtil.getCode(mobile);
        if(code.equals(SMSCode)){
            boolean update = memberService.add(new Member(mobile));
            return R.ok("注册成功",update);
        }else{
            return R.error("验证码错误");
        }

    }


    @ApiOperation(value = "检测手机号是否注册")
    @ApiImplicitParam(name = "mobile" ,value = "手机号",paramType="path")
    @GetMapping("checkMobile/{mobile}")
    public R checkMobile(@PathVariable String mobile){
        Member one = memberService.findOne(new Member(mobile));
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


    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }

}

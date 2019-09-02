package cn.lqcnb.mall.api.controller;

import cn.lqcnb.mall.api.annotation.UserLoginToken;
import cn.lqcnb.mall.api.entity.Address;
import cn.lqcnb.mall.api.service.AddressService;
import cn.lqcnb.mall.common.entity.LayUI;
import cn.lqcnb.mall.common.entity.R;
import cn.lqcnb.mall.common.utils.TokenUtil;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Lin QiCheng
 * Date: 2019/8/25 18:31
 * To change this template use File | Settings | File Templates.
 * Description:
 * Modify by:
 */
@RestController
@CrossOrigin
@Api(tags = "地址管理")
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @UserLoginToken
    @PostMapping("add")
    @ApiOperation("添加地址")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "token",value = "令牌",paramType = "header"),
        @ApiImplicitParam(name = "address",value = "地址",paramType = "query",type = "address")
    })
    public R add(Address address,@RequestHeader String token){
        if(!StringUtils.isEmpty(token))
        address.setMemberId(Integer.parseInt(TokenUtil.getUserId(token)));
        if(address.getIsDefault()==0){
            addressService.setDefault(address.getMemberId());
        }
        if(addressService.add(address)){
            return R.ok();
        }
        return R.error();
    }

    @GetMapping("getById")
    @ApiOperation("获得地址")
    @UserLoginToken
    @ApiImplicitParam(name = "token",value = "令牌",paramType = "header")
    public LayUI getById(@RequestHeader String token){
        Address address = new Address();
        address.setMemberId(Integer.parseInt(TokenUtil.getUserId(token)));
        List<Address> list = addressService.findList(address);
        if(list.size()!=0){
            return LayUI.ok(String.valueOf(list.size()),list);
        }
        return LayUI.error();
    }

    @PostMapping("update")
    @ApiOperation("修改地址")
    public R update(@ApiParam(name = "address",value = "地址") Address address){
        if(address.getIsDefault()==0){
            addressService.setDefault(address.getMemberId());
        }
        if(addressService.update(address)){
            return R.ok("修改成功");
        }
        return R.error();
    }

    @GetMapping("delete/{id}")
    @ApiOperation("删除地址")
    @ApiImplicitParam(name = "id",value = "地址id",paramType = "query")
    public R update(@PathVariable Integer id){
        if(addressService.deleteById(id)){
         return R.ok("删除成功");
        }
        return R.error();
    }
}

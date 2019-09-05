package cn.lqcnb.mall.api.controller;

import cn.lqcnb.mall.api.annotation.UserLoginToken;
import cn.lqcnb.mall.api.entity.Collection;
import cn.lqcnb.mall.api.entity.Goods;
import cn.lqcnb.mall.api.service.CollectionService;
import cn.lqcnb.mall.api.service.GoodsService;
import cn.lqcnb.mall.common.entity.R;
import cn.lqcnb.mall.common.utils.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Lin QiCheng
 * Date: 2019/8/29 23:47
 * To change this template use File | Settings | File Templates.
 * Description:
 * Modify by:
 */
@Api(tags = "收藏管理")
@RestController
@CrossOrigin
@RequestMapping("api/collection")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;
    @Autowired
    private GoodsService goodsService;


    @UserLoginToken
    @ApiOperation(value = "添加")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id" ,value = "商品id",paramType="path",required = true),
            @ApiImplicitParam(name = "token" ,value = "令牌",paramType="header",required = true)
    })
    @GetMapping("add/{id}")
    public R add(@RequestHeader String token, @PathVariable Integer id){


        Collection collection = new Collection();
        collection.setGoodsId(id);
        collection.setMemberId(Integer.parseInt(TokenUtil.getUserId(token)));
        Collection one = collectionService.findOne(collection);
        if(one==null){
            if(collectionService.add(collection)){
                return R.ok();
            }
            return R.error();
        }
       return R.error("已收藏");

    }


    @UserLoginToken
    @ApiOperation(value = "删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id" ,value = "商品id",paramType="path",required = true),
            @ApiImplicitParam(name = "token" ,value = "令牌",paramType="header",required = true)
    })
    @GetMapping("delete/{id}")
    public R del(@RequestHeader String token, @PathVariable Integer id){
        if(collectionService.deleteByUidAndGid(Integer.parseInt(TokenUtil.getUserId(token)),id)){
            return R.ok();
        }
        return R.error();
    }



    @UserLoginToken
    @GetMapping("list")
    @ApiOperation(value = "用户收藏商品数据")
    @ApiImplicitParam(name = "token" ,value = "令牌",paramType="header",required = true)
    public R add(@RequestHeader String token){
        Collection collection = new Collection();
        collection.setMemberId(Integer.parseInt(TokenUtil.getUserId(token)));
        List<Collection> list = collectionService.findList(collection);
        List<Goods> goodsList=new LinkedList<>();
        for(Collection c:list)
        {
            Goods goods = new Goods();
            goods.setId(c.getGoodsId());
            Goods one = goodsService.findOne(goods);
            goodsList.add(one);
        }

        if(goodsList.size()>0){
            return R.ok(goodsList);
        }
        return R.error();
    }
}

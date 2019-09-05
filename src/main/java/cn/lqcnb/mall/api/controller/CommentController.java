package cn.lqcnb.mall.api.controller;

import cn.lqcnb.mall.api.annotation.UserLoginToken;
import cn.lqcnb.mall.api.entity.Collection;
import cn.lqcnb.mall.api.entity.Comment;
import cn.lqcnb.mall.api.entity.Order;
import cn.lqcnb.mall.api.service.CommentService;
import cn.lqcnb.mall.api.service.OrderService;
import cn.lqcnb.mall.common.entity.R;
import cn.lqcnb.mall.common.utils.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * Author: Lin QiCheng
 * Date: 2019/9/3 13:51
 * To change this template use File | Settings | File Templates.
 * Description:
 * Modify by:
 */
@Api(tags = "评论管理")
@RestController
@CrossOrigin
@RequestMapping("api/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private OrderService orderService;


    @ApiOperation(value = "添加")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "comment" ,value = "评论",paramType="query",required = true),
            @ApiImplicitParam(name = "oid" ,value = "订单id",paramType="query",required = true)
    })
    @GetMapping("add")
    public R add(Comment comment,String oid){
        if(commentService.add(comment)){
            //修改订单为完成状态
            Order order = new Order();
            order.setOrderNumber(oid);
            order.setOrderStatus(4);
            orderService.update(order);
            return R.ok();
        }
            return R.error();
    }


    @ApiOperation(value = "评论数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "gid" ,value = "商品id",paramType="path",required = true)
    })
    @GetMapping("getListByPid/{gid}")
    public R getListByPid(@PathVariable Integer gid){
        return R.ok(commentService.getListByGId(gid));
    }

}

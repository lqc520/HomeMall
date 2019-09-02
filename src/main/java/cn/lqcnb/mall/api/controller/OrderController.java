package cn.lqcnb.mall.api.controller;

import cn.lqcnb.mall.api.annotation.UserLoginToken;
import cn.lqcnb.mall.api.entity.*;
import cn.lqcnb.mall.api.service.*;
import cn.lqcnb.mall.common.entity.LayUI;
import cn.lqcnb.mall.common.entity.R;
import cn.lqcnb.mall.common.utils.DateUtils;
import cn.lqcnb.mall.common.utils.OrderIdUtil;
import cn.lqcnb.mall.common.utils.TokenUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.alipay.api.AlipayApiException;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

/**
 * Created with IntelliJ IDEA.
 * Author: Lin QiCheng
 * Date: 2019/8/26 17:02
 * To change this template use File | Settings | File Templates.
 * Description:
 * Modify by:
 */
@RestController
@Api(tags = "订单管理")
@CrossOrigin
@RequestMapping("api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private CardService cardService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private PaymentService paymentService;





    @UserLoginToken
    @PostMapping("add")
    @ApiOperation(value = "订单处理")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "令牌", paramType = "header"),
            @ApiImplicitParam(name = "total_amount", value = "总价格", paramType = "query"),
            @ApiImplicitParam(name = "addressId", value = "总价格", paramType = "query")
    })
    public R add(@RequestHeader String token, @CookieValue String cards, String total_amount,Integer addressId) throws AlipayApiException {

        String userId = TokenUtil.getUserId(token);
        List<Card> cardsList = JSONArray.parseObject(cards, new TypeReference<List<Card>>() {
        });
        String orderId= OrderIdUtil.getOrderCode(Long.parseLong(userId));
        System.out.println(cardsList);
        if (cardsList.size() > 0) {
//            检测库存
            for (Card card : cardsList) {
                if(Integer.parseInt(card.getNumber())>goodsService.getById(card.getGoodsId()).getStock()) {
                    return R.error();
                }
            }
            //添加订单项目
            for (Card card : cardsList) {
               orderItemService.add(new OrderItem(orderId,card.getGoodsId(),card.getName(),card.getAvatar(),"粉红色", Double.parseDouble(card.getPrice()),Integer.parseInt(card.getNumber())));
//                修改库存
                Goods goods = new Goods();
                goods.setId(card.getGoodsId());
                System.out.println(cards);
                goods.setStock(goodsService.getById(card.getGoodsId()).getStock()-Integer.parseInt(card.getNumber()));
                goodsService.update(goods);
//                删除用户购物车信息
                Card curCart = new Card();
                cardService.delete(curCart);
            }
            //添加订单
            Order order = new Order();
            order.setOrderNumber(orderId);
            order.setMemberId(Integer.parseInt(userId));
            order.setPaymentAmount(Double.parseDouble(total_amount));
            order.setAddressId(addressId);
            order.setFreight(0);
            orderService.add(order);
            //添加支付信息
            Payment payment =new Payment();
            payment.setMemberId(Integer.parseInt(userId));
            payment.setOrderNumber(orderId);
            payment.setPaymentAmount(Double.parseDouble(total_amount));
            paymentService.add(payment);
            //支付跳转
//            response.setContentType("text/html;charset=utf-8");
//            System.out.println();
//            String res = paymentService.goPay(orderId, total_amount, "test");
//            System.out.println(res);
//            return res;
//            out.write(res);
           return R.ok("ok",orderId);
        }
       return R.error();

    }



    @UserLoginToken
    @GetMapping("getOrder/{orderStatus}")
    @ApiOperation(value = "获取订单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "令牌", paramType = "header"),
            @ApiImplicitParam(name = "orderStatus", value = "状态", paramType = "path")
    })
    public LayUI getOrder(@RequestHeader String token,@PathVariable Integer orderStatus){
        Map map = new HashMap();
        map.put("memberId",Integer.parseInt(TokenUtil.getUserId(token)));
        map.put("orderStatus",orderStatus);
        List<Map> order = orderService.getOrder(map);
        List<Map> orderTime=null;
        if (order.size()!=0){
            for(Map m:order){
                Object paymentTime = m.get("paymentTime");
                if(paymentTime!=null){
                    SimpleDateFormat formater = new SimpleDateFormat(
                            "yyyy-MM-dd HH:mm:ss");
                    m.put("paymentTime",formater.format(new Date( m.get("paymentTime").toString())));
                    orderTime.add(m);
                }

            }
            System.out.println(orderTime);
            return LayUI.ok(String.valueOf(order.size()),order);
        }
        return LayUI.error();
    }


    @GetMapping("getOrderList")
    @ApiOperation(value = "获取订单信息")
    @ApiImplicitParam(name = "Order", value = "查询参数信息", paramType = "order")
    public R getOrderList(Order order){
        List<Map> orderList = orderService.getOrderList(order);
        if(orderList.size()!=0){
          return R.ok(orderList);
        }
        return R.error();
    }


    @GetMapping("update")
    @ApiOperation(value = "修改订单信息")
    @ApiImplicitParam(name = "Order", value = "查询参数信息", paramType = "order")
    public R update(Order order){
        /**
         * 订单状态
         0 待支付
         1 待发货
         2 待收货
         3 待评价
         4 已完成
         5 交易关闭*/
        if(order.getOrderStatus()==2){
            order.setSendTime(new Date());
        }else if(order.getOrderStatus()==4){
            order.setFinishTime(new Date());
        }else if(order.getOrderStatus()==5){
            order.setCancelTime(new Date());
        }
        if(orderService.update(order)){
            return R.ok();
        }
        return R.error();
    }


    @GetMapping("updateOrderStates")
    @ApiOperation(value = "订单收货")
    @ApiImplicitParam(name = "Order", value = "订单", paramType = "order")
    public R updateOrderStates(Order order){
        order.setOrderStatus(4);
        order.setFinishTime(new Date());
        if(orderService.update(order)){
            return R.ok();
        }
        return R.error();
    }

}

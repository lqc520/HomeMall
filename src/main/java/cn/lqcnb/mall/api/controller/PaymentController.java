package cn.lqcnb.mall.api.controller;


import cn.lqcnb.mall.api.entity.Order;
import cn.lqcnb.mall.api.entity.Payment;
import cn.lqcnb.mall.api.service.OrderService;
import cn.lqcnb.mall.api.service.PaymentService;
import cn.lqcnb.mall.common.entity.R;
import com.alipay.api.AlipayApiException;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Author: Lin QiCheng
 * Date: 2019/8/25 12:51
 * To change this template use File | Settings | File Templates.
 * Description:
 * Modify by:
 */
@RestController
@CrossOrigin
@Api(tags = "支付接口")
@RequestMapping("api/pay")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private OrderService orderService;


    @ApiOperation(value = "支付信息")
    @GetMapping("/list")
    public R list(){
        List<Payment> list = paymentService.findAll();
        if(list!=null){
            return R.ok(list);
        }
        return R.error();
    }


    @ApiOperation(value = "支付宝支付")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "out_trade_no",value = "订单编号",paramType = "query",required = true),
            @ApiImplicitParam(name = "total_amount",value = "价格",paramType = "query",required = true),
            @ApiImplicitParam(name = "subject",value = "商品名称",paramType = "query",required = true),
    })
    @PostMapping("/goPay")
    public String goPay(String out_trade_no,String total_amount,String subject) throws AlipayApiException, UnsupportedEncodingException {
        String res=paymentService.goPay(out_trade_no,total_amount,subject);
        System.out.println(res);
        return res;
    }


    @ApiOperation(value = "支付宝支付")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "out_trade_no",value = "订单编号",paramType = "query",required = true),
            @ApiImplicitParam(name = "total_amount",value = "价格",paramType = "query",required = true),
            @ApiImplicitParam(name = "subject",value = "商品名称",paramType = "query",required = true),
    })
    @GetMapping("/goPay")
    public String goPay1(String out_trade_no,String total_amount,String subject) {
        String res=paymentService.goPay(out_trade_no,total_amount,subject);
        System.out.println(res);
        return res;
    }


    @GetMapping("/succeed")
    public void succeed(@RequestParam Map map, HttpServletResponse response, PrintWriter out){
        System.out.println("succeed");
        if(map.size()!=0){
            //添加订单支付完成时间
            Order order = new Order();
            System.out.println(map.get("out_trade_no").toString());
            order.setOrderNumber(map.get("out_trade_no").toString());
            order.setPaymentTime(Timestamp.valueOf(map.get("timestamp").toString()));
            order.setOrderStatus(1);
            orderService.update(order);
            //添加回调支付信息
            Payment payment = new Payment();
            payment.setPaymentAmount(Double.parseDouble(map.get("total_amount").toString()));
            payment.setPaymentStatus(1);
            payment.setPaymentNumber(map.get("trade_no").toString());
            paymentService.updateByOId(payment,map.get("out_trade_no").toString());
            response.setContentType("text/html;charset=utf-8");
            out.println("<html>");
            out.println("<script>");
            out.println("window.location.href='http://mall.lqcnb.cn/html/user.html'");
            out.println("</script>");
            out.println("</html>");
            out.flush();
            out.close();
        }



    }
    /**
     * 支付成功后的回调地址
     *
     * @return
     */
    @GetMapping("/notify")
    @ApiOperation("支付回调")
    public void notifyPay(@ApiParam(hidden = true) @RequestParam Map map, @ApiParam(hidden = true) HttpServletResponse response, @ApiParam(hidden = true) PrintWriter out) throws UnsupportedEncodingException {
        System.out.println("支付回调");
        System.out.println(map);
        //paymentService.afterPay(orderNumber,paymentNumber,paymentAmount);
        if(map.size()!=0){
            //添加订单支付完成时间
            Order order = new Order();
            System.out.println(map.get("out_trade_no").toString());
            order.setOrderNumber(map.get("out_trade_no").toString());
            order.setPaymentTime(Timestamp.valueOf(map.get("timestamp").toString()));
            order.setOrderStatus(1);
            orderService.update(order);
            //添加回调支付信息
            Payment payment = new Payment();
            payment.setPaymentAmount(Double.parseDouble(map.get("total_amount").toString()));
            payment.setPaymentStatus(1);
            payment.setPaymentNumber(map.get("trade_no").toString());
            paymentService.updateByOId(payment,map.get("out_trade_no").toString());
            response.setContentType("text/html;charset=utf-8");
            out.println("<html>");
            out.println("<script>");
            out.println("window.location.href='http://mall.lqcnb.cn/html/user.html'");
            out.println("</script>");
            out.println("</html>");
            out.flush();
            out.close();
        }


    }
//                    "charset": "utf-8",
//                    "out_trade_no": "1103",
//                    "method": "alipay.trade.page.pay.return",
//                    "total_amount": "500.00",
//                    "sign": "k1ZhsPgoeRgKQxeeo2Pxmrkc1/w0XpZa09jdXcWqTk9AHIm5GolozgXxoFaBaLzpiKtkprAYlwxVGgDYyFtKZ0N/qWNVGkUbF/bjf29/+9D/TVgmxdjiqKWGdKmGjTLSEb1LVjILXp4zGU+SHWnq+8SezFppwo3dvOw067OEMz3D4uzuEsBlbIsg9wsSAjbGgt3LLUJRIGELh4rzXJOHdi+UeZ6s1br8VNL2u9N95jCpjdBAIvChC30P4rMgd41DFrkXGk12HnKzU/dluFnArEZykppjEPupAbk6/gZkY6O56Vza+ObSqfxmIdrxxEmo9F3x1dl4CS9PDBDuWUovhQ==",
//                    "trade_no": "2019082622001461370500630559",
//                    "auth_app_id": "2016101000650830",
//                    "version": "1.0",
//                    "app_id": "2016101000650830",
//                    "sign_type": "RSA2",
//                    "seller_id": "2088102178890583",
//                    "timestamp": "2019-08-26 13:45:23"
/*===========================IJPay==============================================================================*/


}




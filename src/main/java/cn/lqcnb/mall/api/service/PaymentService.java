package cn.lqcnb.mall.api.service;

import cn.lqcnb.mall.api.config.AlipayConfig;
import cn.lqcnb.mall.api.entity.Payment;
import cn.lqcnb.mall.api.mapper.PaymentMapper;
import cn.lqcnb.mall.common.service.AbstractService;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA.
 * Author: Lin QiCheng
 * Date: 2019/8/26 12:16
 * To change this template use File | Settings | File Templates.
 * Description:
 * Modify by:
 */
@Service
public class PaymentService extends AbstractService<Payment> {
    @Resource
    private PaymentMapper paymentMapper;


    public String goPay(String out_trade_no,String total_amount,String subject)  {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.lqc_return_url);//设置支付成功回调地址


        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                // + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        try {
            return alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }


    public boolean updateByOId(Payment payment,String orderNumber){
        Example example = new Example(Payment.class);
        example.createCriteria().andEqualTo("orderNumber",orderNumber);
        return paymentMapper.updateByExampleSelective(payment,example)>0;
    }
}

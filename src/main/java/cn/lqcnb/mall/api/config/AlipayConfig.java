package cn.lqcnb.mall.api.config;

/**
 * Created with IntelliJ IDEA.
 * Author: Lin QiCheng
 * Date: 2019/8/24 21:25
 * To change this template use File | Settings | File Templates.
 * Description:
 * Modify by:
 */

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101000650830";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCKAKDYYAT1u2slq/LDbBVlQfSKetJKgvPMdBEjF+TK/sOju2tH4whNsRlD4sg/tl8j8ZIdkjLHW/wffUdmZ47cNuDQqqeQK60TU0K26BKIL4QoDd+PK7fXf0dO77VlsxIJXC24hQCJFeN6FjOg7E57k9/nqx3samqp3MuYNkhuKivtFyiQjwshoQDtfLwJWZ/w2O+sItelswPagCJ3iXtcKkBA5YNaUFL8KAYpiGcAQdn4cQcD898JhhFCq/aSGEPTov3235mZhjzi6++PGh5PJjv4vonjk6Krz5c+joAr4hmAzCWK8+Zh/t3CokfQkwwTITUTESjTHBB8AET9jeoPAgMBAAECggEBAIRlo+rS/A8xFtPWipp4KHKz+0OcIAKCbhnZxNMxSjyCfPmphnw6US4QWVfqzAlsEwzt5yvdpj/jfRhM3eJeOg4FzFwFTasga/TdbWUDczwasiSnYrL902u43ZXaneKLESPPvsGHQINEb7AierfJ3mXq8eZWIeg+FEUQ4ncOpSCihNcTy/qFbeedqCsO3wouRiKjc1Mcui3mMHjDdip2I4kahnOpIys2eWi+ckCDPKJvnmeQDHopXvnjgqJMYrOphUr8/VEy5FpqxQlUt/eNPqE4YfHZs1nHq1JF3j0IifVaK0hb/65FHNFa177A1IWOHMwOzuMLJRPKweA11GATaHkCgYEAzYoyCgW3CMsm9FDctI5LqXya/eYql4KWZyaQXXzflTnANxQYHip0BE3QWoUL6m2+hKWQrz3niGM8hfrMxj7/uV36XGtzxR206ApYPT65ZcVaXbiprvffpep3E2eD2YNS36Cfd6YgDQ0ASWUdnAtQJUE6epWE14i8NXraC7qtMNMCgYEAq+HU7jYmPhzCjGx0RpXzNxxoXLkZapbAQl38a4wjv7XEpoQaQDxsPjPWb01Q52dM57qBDTn0R2zGPOQ+lvkHGj2wk9bE0vvryFb61yX718cMjGgfa4lwkNao354gQ1ADtxcyU42BYgyj0/HMZhJj/Wd799IzM9yJTjB5cKvv/FUCgYB2gYlcUfM4NLlfAAhgafKh4+ARJ9XCyV4iVw/BdzAJ/+QdXY6SRfPiT2Mj7bXzEhdYr4T+JPkLn/vTW8kZPFWA8PhatPFo4znc16oMlc+bJ/B0PPZIlU3zgX3qSDKzBI6RtTB8ceHk5GwX5R7vS26ILFWlO/P9uS6avxxcyuL0VQKBgQCO/Pgek32M/m/6Ud8JOYVzu3Y2bOXv/ilDDN0IuzSiL5zAyfTsq1eBB67EORWs7ArWXBkv356QLLVdwqMvBUwbUGatFmX2/wxPRcy3Xyn7f+O4ioZY96VlWK50GR/N36q3jdyYFYglAU7o6qaX44S7MnO23m8qHbU8Dqd4TBEBYQKBgF8N3d5QPZz0ULjQ64mJ3IajhJNets6H6Etie4djvbPcs/tjw5qk4rJXZLWTYcnZL8UINQtlKHGbFMotc1L+gT8tu41jhhwk547IsnsBvNP2gmD5RwbLRxB4ctbn44FYPEzwArXrci/fJA1IJ9PiTiQLMGbpjC+zdRLNROoAkXWI";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnKiHotrSHzq1wfoJ4YodQs8qWDxXlLweeD55JBbWj7dV8FbNDW+68M3RrCGwgJzaSQrsw6QNhKRbcwVqmxDsFoCSOwSVj2/1jNUpG/vKRV8gPOFVqiiPNxg6cAGN8N2YFpprroCIYFH1DZ+P24LH+gieHizNHbVzPJdfjrQ0nxd3DaOenI4ap/VCEryV0ZWDuZuBZIijsyk91dcrF+dZ8sWWl3p2K8WKl8LcvAwQsz3yA5ibTHGIgyCkowDLj6ZmXk6uO1Q4TBwzT/zGAyW0KKjb22LB2MOOoMQzddYkivQZ+4G9oJ6C3LcA40m8TK1w4MeGsT6iKkjFNFDLLsceBwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String lqc_notify_url = "http://mall.lqcnb.cn/api/pay/notify";


    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String lqc_return_url = "http://mall.lqcnb.cn/api/pay/succeed";


    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


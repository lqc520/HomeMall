package cn.lqcnb.mall.common.utils;

import com.aliyun.oss.OSSClient;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public class UploadUtil {


    public static String upload(MultipartFile file,String Catalog) {
        try {
            // Endpoint以杭州为例，其它Region请按实际情况填写。
            String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
            // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
            String accessKeyId = "LTAI6E7RqU9Ngoj4";
            String accessKeySecret = "ag3CrDOcmlJpefRkNibVNBpMdfV2eA";
            // 创建OSSClient实例。
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            String uploadFilename = file.getOriginalFilename();
            // 生成新的文件名
            String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
            String newFilename =Catalog+"/"+uuid + uploadFilename.substring(uploadFilename.lastIndexOf("."));
            ossClient.putObject("lqcblog", newFilename, file.getInputStream());
            // 关闭OSSClient。
            ossClient.shutdown();

            return "https://lqcblog.oss-cn-shenzhen.aliyuncs.com/"+ newFilename;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

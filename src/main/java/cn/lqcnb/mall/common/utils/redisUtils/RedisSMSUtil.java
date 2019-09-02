package cn.lqcnb.mall.common.utils.redisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
@Component
public class RedisSMSUtil{

    @Autowired
    private final StringRedisTemplate redisTemplate;

    public RedisSMSUtil(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    /**
     *
     * @param mobile 手机号
     * @param code 验证码
     * @param time 验证码有效期
     */
    public  void setCodeTime(String mobile,String code,long time){
        redisTemplate.opsForValue().set("mobile_code:"+mobile,code);
        redisTemplate.expire("mobile_code:"+mobile,time, TimeUnit.SECONDS);
    }


    /**
     *
     * @param mobile 手机号
     * @return 验证码
     */
    public  String getCode(String mobile){
        return redisTemplate.opsForValue().get("mobile_code:"+mobile);
    }



    /**
     *
     * @param email 邮箱
     * @param code 邮箱验证码
     * @param time 验证码有效期
     */
    public  void setEmailCodeTime(String email,String code,long time){
        redisTemplate.opsForValue().set("email_code:"+email,code);
        redisTemplate.expire("email_code:"+email,time, TimeUnit.SECONDS);
    }


    /**
     *
     * @param email 邮箱
     * @return 验证码
     */
    public  String getEmailCode(String email){
        return redisTemplate.opsForValue().get("email_code:"+email);
    }


}

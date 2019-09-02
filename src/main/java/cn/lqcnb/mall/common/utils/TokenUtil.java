package cn.lqcnb.mall.common.utils;

import cn.lqcnb.mall.api.entity.Member;
import cn.lqcnb.mall.api.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class TokenUtil {
    public static String getToken(Member user) {
        String token="";
        token= JWT.create().withAudience(user.getId().toString())
                .sign(Algorithm.HMAC256(user.getMobile()));
        return token;
    }

    public static String getAdminToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getId().toString())
                .sign(Algorithm.HMAC256(user.getMobile()));
        return token;
    }

    public static String getUserId(String token){
        return JWT.decode(token).getAudience().get(0);
    }
}
//Algorithm.HMAC256():使用HS256生成token,密钥则是用户的密码，
//        唯一密钥的话可以保存在服务端。
//        withAudience()存入需要保存在token的信息，这里我把用户ID存入token中

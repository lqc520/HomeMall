package cn.lqcnb.mall.api.controller;



import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


public class Test {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put("a","/common/img/goods_img1.jpg");
        map.put("b","/common/img/goods_img2.jpg");
        map.put("c","/common/img/goods_img3.jpg");
        Object json = JSONArray.toJSON(map);
        System.out.println(json);
    }
}

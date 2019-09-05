package cn.lqcnb.mall.api.controller;

import cn.lqcnb.mall.api.entity.Sort;
import cn.lqcnb.mall.api.service.SortService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * Author: Lin QiCheng
 * Date: 2019/8/25 11:34
 * To change this template use File | Settings | File Templates.
 * Description:
 * Modify by:
 */


@RestController
@CrossOrigin
@Api(tags = "二级分类管理")
@RequestMapping("api/sort")
public class SortController {
    @Autowired
    private SortService sortService;

    @GetMapping("list")
    @ApiOperation(value = "获取分类数据",notes = "获取分类数据")
    public List<Sort> getList(){
        return sortService.findAll();
    }


    @ApiOperation(value = "微信分类栏目数据")
    @GetMapping("/wxList")
    public List<Map> wxList(){
        List<Sort> sort = sortService.findAll();
       List<Map> list =new LinkedList<>();
        Map item=new HashMap();
        item.put("id","home");
        item.put("banner","/image/c1.png");
        item.put("cate","首页");
        item.put("detail",sort);
        list.add(item);
        Map item1=new HashMap();
        item1.put("id","house");
        item1.put("banner","/image/c1.png");
        item1.put("cate","居家用品");
        item1.put("detail",sort);
        list.add(item1);
        Map item2=new HashMap();
        item2.put("id","small");
        item2.put("banner","/image/c1.png");
        item2.put("cate","小家电");
        item2.put("detail",sort);
        list.add(item2);
        Map item3=new HashMap();
        item3.put("id","daily");
        item3.put("banner","/image/c1.png");
        item3.put("cate","日用品");
        item3.put("detail",sort);
        list.add(item3);
        Map item4=new HashMap();
        item4.put("id","wash");
        item4.put("banner","/image/c1.png");
        item4.put("cate","洗护");
        item4.put("detail",sort);
        list.add(item4);
        Map item5=new HashMap();
        item5.put("id","kitchen");
        item5.put("banner","/image/c1.png");
        item5.put("cate","厨具");
        item5.put("detail",sort);
        list.add(item5);
        return list;
    }

}

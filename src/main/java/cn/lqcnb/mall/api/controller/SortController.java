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

import java.util.List;


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

}

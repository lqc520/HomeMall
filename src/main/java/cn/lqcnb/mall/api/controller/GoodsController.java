package cn.lqcnb.mall.api.controller;

import cn.lqcnb.mall.api.entity.Goods;
import cn.lqcnb.mall.api.service.GoodsService;
import cn.lqcnb.mall.common.entity.LayUI;
import cn.lqcnb.mall.common.entity.R;
import cn.lqcnb.mall.common.utils.UploadLocalUtil;
import cn.lqcnb.mall.common.utils.UploadUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.PortUnreachableException;
import java.util.HashMap;
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
@Api(tags = "商品管理")
@RequestMapping("api/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService ;


    @ApiOperation(value = "获取全部商品数据")
    @GetMapping("/list")
    public List<Goods> findAll(){
        return goodsService.findAll();
    }


    @ApiOperation(value = "获取类别商品数据")
    @ApiImplicitParam(name = "id",value = "类别id",paramType = "path")
    @GetMapping("/getListBySortId/{id}")
    public List<Goods> getListBySortId(@PathVariable Integer id){
        Goods params = new Goods();
        params.setSortId(id);
        return goodsService.findList(params);
    }


    @ApiOperation(value = "获取类别商品数据")
    @ApiImplicitParam(name = "name",value = "商品名",paramType = "path")
    @GetMapping("/search/{name}")
    public List<Goods> getSearchByName(@PathVariable String name){
       return goodsService.search(name);
    }


    @ApiOperation(value = "获取全部商品数据")
    @GetMapping("/getList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "当前页",paramType = "query"),
            @ApiImplicitParam(name = "limit",value = "分页条数",paramType = "query"),
            @ApiImplicitParam(name = "goods",value = "查询条件",paramType = "query")
    })
    public LayUI getList(Integer page, Integer limit,Goods goods){
        List<Map> list = goodsService.getList(page,limit,goods);
        return LayUI.ok(String.valueOf(goodsService.findAll().size()),list);
    }


    @ApiOperation(value = "获取全部商品分页数据")
    @GetMapping("/pageList/{pageNum}/{pageSize}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "当前页",paramType = "path",required = true),
            @ApiImplicitParam(name = "pageSize",value = "分页条数",paramType = "path",required = true)
    })
    public PageInfo<Goods> getPageList(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
        PageInfo<Goods> page = goodsService.findPage(new Goods(), pageNum, pageSize);//findPage设置了size
        return page;
    }

    @ApiOperation(value = "获取详情分页数据")
    @GetMapping("/getPageList/{pageNum}/{pageSize}/{categoryId}/{sortId}/{seasonId}/{orderType}/{byOrder}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "当前页",paramType = "path",required = true),
            @ApiImplicitParam(name = "pageSize",value = "分页条数",paramType = "path",required = true),
            @ApiImplicitParam(name = "categoryId",value = "分类id",paramType = "path",required = true),
            @ApiImplicitParam(name = "sortId",value = "二级类别id",paramType = "path",required = true),
            @ApiImplicitParam(name = "seasonId",value = "季节id",paramType = "path",required = true),
            @ApiImplicitParam(name = "orderType",value = "byTime|byPrice",paramType = "path",required = true),
            @ApiImplicitParam(name = "byOrder",value = "ASC|DESC",paramType = "path",required = true),
    })
    public PageInfo getDetailPageList(@ApiParam(hidden = true)@PathVariable Map map)
    {
        System.out.println(map);
       return goodsService.getPageList(map,Integer.parseInt(map.get("pageNum").toString()),Integer.parseInt(map.get("pageSize").toString()));
    }


    @ApiOperation(value = "通过id获取商品数据")
    @GetMapping("/getById/{id}")
    @ApiImplicitParam(name = "id",value = "商品id",paramType = "path",required = true)
    public Goods getGoodsById(@PathVariable Integer id){
            return goodsService.getById(id);
    }


    //后期用redis 记录用户浏览的商品id 推送喜欢
    @ApiOperation(value = "猜你喜欢")
    @GetMapping("/getRandList")
    public R getRandList(){
        return R.ok(goodsService.getRandList(16));
    }


    //后期用redis 记录用户浏览的商品id 推送喜欢
    @ApiOperation(value = "猜你喜欢")
    @GetMapping("/cartlike")
    public R like(){
        return R.ok(goodsService.getRandList(5));
    }

    @ApiOperation(value = "热销推荐")
    @GetMapping("/getHot")
    public R getHot(){
        return R.ok(goodsService.getRandList(4));
    }


    @ApiOperation(value = "新品推荐")
    @GetMapping("/getNew")
    public R getNew(){
        return R.ok(goodsService.getRandList(4));
    }


    @ApiOperation(value = "上传图片")
    @PostMapping("/upload")
    public R upload(@RequestParam(value = "file") MultipartFile file){
        if(file.isEmpty()){
            return R.error();
        }
        //阿里云 linux云端部署上传到阿里云oss
        String AliPath = UploadUtil.upload(file,"mall");
        //win10 本地部署 上传到本地资源
//        String winPath = UploadLocalUtil.addImg(file);
        return R.ok("ok", AliPath);

    }


    @ApiOperation(value = "多文件上传图片")
    @PostMapping("/uploadImg")
    public R uploadImg(@RequestParam(value = "file") MultipartFile file[]){
        if(file.length!=0){
            String detail="";
           for(MultipartFile f:file){
//               detail +=  goodsService.addImg(f)+",";
               //阿里云 linux云端部署上传到阿里云oss
               detail += UploadUtil.upload(f,"mall")+",";
               //win10 本地部署 上传到本地资源
//               detail += UploadLocalUtil.addImg(f);

           }
            System.out.println(detail);
           return R.ok("ok",detail);

        }
       return R.error();
    }




    @ApiOperation(value = "添加")
    @GetMapping("/add")
    @ApiImplicitParam(name = "goods",value = "商品",paramType = "query",dataType = "goods")
    public R add(Goods goods){
        if(goodsService.add(goods)){
            return R.ok();
        }
        return R.error();
    }


    @ApiOperation(value = "修改")
    @GetMapping("/update")
    @ApiImplicitParam(name = "goods",value = "商品",paramType = "query",dataType = "goods")
    public R update(Goods goods){
        if(goodsService.update(goods)){
            return R.ok();
        }
        return R.error();
    }

    @ApiOperation(value = "修改商品详图")
    @GetMapping("/updateDIMG")
    @ApiImplicitParam(name = "goods",value = "商品",paramType = "query",dataType = "goods")
    public R updateDIMG(Goods goods){
        if(goodsService.update(goods)){
            return R.ok();
        }
        return R.error();
    }


    @ApiOperation(value = "删除")
    @GetMapping("/delete/{id}")
    @ApiImplicitParam(name = "id",value = "商品id",paramType = "path")
    public R delete(@PathVariable Integer id){
        if(goodsService.deleteById(id)){
            return R.ok();
        }
        return R.error();
    }




}

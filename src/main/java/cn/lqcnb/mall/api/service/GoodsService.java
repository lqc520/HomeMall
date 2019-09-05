package cn.lqcnb.mall.api.service;

import cn.lqcnb.mall.api.entity.Goods;
import cn.lqcnb.mall.api.mapper.GoodsMapper;
import cn.lqcnb.mall.common.entity.R;
import cn.lqcnb.mall.common.service.AbstractService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class GoodsService extends AbstractService<Goods> {
    @Resource
    private GoodsMapper goodsMapper;


    public PageInfo<Goods> getPageList(Map map, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Goods> pageList = goodsMapper.getPageList(map);
        System.out.println(pageList);
        return new PageInfo<>(pageList);
    }

    public List<Goods> getRandList(Integer limit){
       return goodsMapper.getRandList(limit);
    }

    public  List<Map> getList(Integer pageNum, Integer pageSize,Goods goods){
        if(pageNum==null||pageNum<0){
            pageNum=1;
        }
        if(pageSize==null){
            pageSize=10;
        }
        PageHelper.startPage(pageNum,pageSize);
        List<Map> list = goodsMapper.getList(goods);
        return new PageInfo<>(list).getList();
//        return goodsMapper.getList();
    }

    public String addImg(MultipartFile file){
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize()/1024/1024;
        System.out.println(fileName + "-->" + size+"Mb");

        String path = "E:/Study/Junior/JavaEE/idea_Program/mall/src/main/resources/static/common/img" ;
        File dest = new File(path + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            return "/common/img/"+fileName;
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return e.getMessage();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public List<Goods> search(String name){
        return goodsMapper.search(name);
    }






}

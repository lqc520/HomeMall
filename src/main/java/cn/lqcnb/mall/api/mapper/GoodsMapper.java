package cn.lqcnb.mall.api.mapper;

import cn.lqcnb.mall.api.entity.Goods;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface GoodsMapper extends Mapper<Goods> {
    public List<Goods> getPageList(Map map);
    @Select("SELECT * FROM `mall_goods` ORDER BY  RAND() LIMIT #{limit}")
    public List<Goods> getRandList(Integer limit);
    public List<Map> getList(Goods goods);
}
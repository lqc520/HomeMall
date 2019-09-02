package cn.lqcnb.mall.api.mapper;

import cn.lqcnb.mall.api.entity.Order;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface OrderMapper extends Mapper<Order> {
    public List<Map> getOrder(Map map);
    public List<Map> getOrderList(Order order);
}
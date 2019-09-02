package cn.lqcnb.mall.api.mapper;

import cn.lqcnb.mall.api.entity.Card;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CardMapper extends Mapper<Card> {
    public List<Card> getCards(String[] ids);
}
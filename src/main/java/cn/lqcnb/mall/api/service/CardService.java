package cn.lqcnb.mall.api.service;

import cn.lqcnb.mall.api.entity.Card;
import cn.lqcnb.mall.api.mapper.CardMapper;
import cn.lqcnb.mall.common.service.AbstractService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CardService extends AbstractService<Card> {
    @Resource
    private CardMapper cardMapper;

    public List<Card> getCards(String[] ids){
        return cardMapper.getCards(ids);
    }

    public boolean update(Card card,Integer goodsId,Integer memberId){
        Example example = new Example(Card.class);
        example.createCriteria().andEqualTo("goodsId",goodsId).andEqualTo("memberId",memberId);
        return cardMapper.updateByExampleSelective(card,example)>0;
    }

    public boolean updateCount(Card cart){
        Example example = new Example(Card.class);
        example.createCriteria().andEqualTo("goodsId",cart.getGoodsId()).andEqualTo("memberId",cart.getMemberId());
        return cardMapper.updateByExampleSelective(cart,example)>0;
    }

    public Card cheCart(Card cart) {
        Example example = new Example(Card.class);
        example.createCriteria().andEqualTo("goodsId",cart.getGoodsId()).andEqualTo("memberId",cart.getMemberId());
        return cardMapper.selectOneByExample(example);
    }
}

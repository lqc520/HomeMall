package cn.lqcnb.mall.api.controller;

import cn.lqcnb.mall.api.annotation.UserLoginToken;
import cn.lqcnb.mall.api.entity.Card;
import cn.lqcnb.mall.api.entity.Goods;
import cn.lqcnb.mall.api.service.CardService;
import cn.lqcnb.mall.api.service.GoodsService;
import cn.lqcnb.mall.common.entity.R;
import cn.lqcnb.mall.common.utils.TokenUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import io.swagger.annotations.*;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
@Api(tags = "购物车管理")
@CrossOrigin
@RequestMapping("api/cart")
public class CardController {
    @Autowired
    private CardService cardService;
    @Autowired
    private GoodsService GoodsService;

    // 废弃
    @ApiOperation("获取购物车数据")
    @GetMapping("getCards")
    public Map getCards(@CookieValue(required = false) String cards){
        System.out.println(cards);
        Map map = new HashMap();
        if(!StringUtils.isEmpty(cards)){
            List<Map> maps = JSONArray.parseObject(cards, new TypeReference<List<Map>>() {
            });
            String ids="";
            String nums="";
            for (Map m : maps){
                ids += m.get("goodsId").toString()+",";
                nums += m.get("number").toString()+",";  //number

            }
            List<Card> cardsList = cardService.getCards(ids.split(","));
            System.out.println(cardsList);
            int i=0;
            String[] num = nums.split(",");
            for (Card card : cardsList){
                card.setNumber(num[i++]);
            }
            map.put("code",0);
            map.put("count",cardsList.size());
            map.put("data",cardsList);
            map.put("msg","获取数据成功");
        }else{
            map.put("code",1);
            map.put("msg","没有数据 请先去逛逛");
            map.put("count",0);
            map.put("data",null);
        }

        return map;
    }


    @UserLoginToken
    @ApiOperation("获取购物车数据")
    @GetMapping("getCardList")
    @ApiImplicitParam(name = "token",value = "令牌",paramType = "header",required = true)
    public R getCardList(@RequestHeader String token) {
        Card cart = new Card();
        cart.setMemberId(Integer.parseInt(TokenUtil.getUserId(token)));
        List<Card> CardList = cardService.findList(cart);
        if(CardList.size()>0){
            List<Card> resultList=new LinkedList<>();
            for(Card card : CardList){
                //检测库存 和价格变动
                Goods curGoods = GoodsService.getById(card.getGoodsId());
                if(Integer.parseInt(card.getNumber())>curGoods.getStock()){
                    card.setNumber(String.valueOf(curGoods.getStock()));
                }
                if(!card.getPrice().equals(curGoods.getPrice())){
                    card.setPrice(curGoods.getPrice().toString());
                }
                resultList.add(card);
            }
            return R.ok(resultList);
        }
        return R.error();
    }


    @UserLoginToken
    @GetMapping("updateNumber/{goodsId}/{number}")
    @ApiOperation("修改商品数量")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodsId",value = "商品id",paramType = "path",required = true),
            @ApiImplicitParam(name = "number",value = "数量",paramType = "path",required = true),
            @ApiImplicitParam(name = "token",value = "令牌",paramType = "header",required = true)
    })
    public R updateNumber(@PathVariable Integer goodsId, @PathVariable String number, @RequestHeader String token, @ApiParam(hidden = true)HttpServletResponse response){
        Card params = new Card();
        params.setNumber(number);
        if(cardService.update(params,goodsId,Integer.parseInt(TokenUtil.getUserId(token)))){
            try {
                Card param =new Card();
                param.setMemberId(Integer.parseInt(TokenUtil.getUserId(token)));
                List<Card> updateCookie = cardService.findList(param);
                String encode = URLEncoder.encode(JSONArray.toJSONString(updateCookie), "UTF-8");
                Cookie newCard = new Cookie("cards", encode);
                newCard.setPath("/");
                newCard.setMaxAge(60 * 60 * 24 * 7);
                response.addCookie(newCard);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            return   R.ok();
        }
        return R.error();
    }


    @UserLoginToken
    @GetMapping("getCount")
    @ApiOperation("获取商品数量")
    @ApiImplicitParam(name = "token",value = "令牌",paramType = "header",required = true)
    public R getCount(@RequestHeader String token){
        Card params= new Card();
        params.setMemberId(Integer.parseInt(TokenUtil.getUserId(token)));
        List<Card> list = cardService.findList(params);
        return R.ok(list.size());
    }


    @UserLoginToken
    @GetMapping("delete/{id}")
    @ApiOperation("获取商品数量")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token",value = "令牌",paramType = "header",required = true),
            @ApiImplicitParam(name = "id",value = "购物车id",paramType = "query",required = true)
    })
    public R delete(@RequestHeader String token,@PathVariable Integer id){
        if(cardService.deleteById(id)){
            return R.ok();
        }
        return R.error();
    }


    @UserLoginToken
    @GetMapping("addCart")
    @ApiOperation("商品加入购物车")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token",value = "令牌",paramType = "header",required = true),
            @ApiImplicitParam(name = "cart",value = "商品",paramType = "query",required = true)
    })
    public R addCart(@RequestHeader String token,Card cart){
        cart.setMemberId(Integer.parseInt(TokenUtil.getUserId(token)));
        Card curCart = cardService.cheCart(cart);
        if(curCart!=null){
            Card params = new Card();
            params.setNumber(String.valueOf(Integer.parseInt(curCart.getNumber())+Integer.parseInt(cart.getNumber())));
            if(cardService.updateCount(params)){
                return R.ok();
            }
            return R.error();
        }else{
            if(cardService.add(cart)){
                return R.ok();
            }
            return R.error();
        }
    }
}

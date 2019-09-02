package cn.lqcnb.mall.api.controller;

import cn.lqcnb.mall.api.annotation.UserLoginToken;
import cn.lqcnb.mall.api.entity.Card;
import cn.lqcnb.mall.api.entity.Goods;
import cn.lqcnb.mall.api.service.CardService;
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
}

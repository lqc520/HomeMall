#                项目名称：商城

##### 本项目是一个前后端分离项目 前台有LayUI做界面Vue数据渲染 后台SpringBoot+Swagger2 做api接口  JWT token做权限验证
![homemall](https://img.shields.io/badge/homemall-v1.0-yellow)
## 技术栈

- SpingBoot

- Mybatis

- Mysql

- Redis

- JWT

- SMS

- Cookie购物车

- 支付宝沙箱

- AliOSS

- Vue

- LayUI

- ES6

- LNMP

  

  

## API接口 ：http://mall.lqcnb.cn/swagger-ui.html

## 项目声明：本项目为学年设计 不能用作商业用途

## 项目前台：http://mall.lqcnb.cn/html/index.html

## 项目后台：http://mall.lqcnb.cn/views/index.html

![1567349138926](https://github.com/lqc520/HomeMall/blob/master/assess/1567349138926.png)

## JAEE技术栈

![javaEEtechnologystack](https://github.com/lqc520/HomeMall/blob/master/assess/javaEEtechnologystack.png)

# 项目图片

###   首页

  ![1567347201439](https://github.com/lqc520/HomeMall/blob/master/assess/1567347201439.png)

  

![1567347233996](https://github.com/lqc520/HomeMall/blob/master/assess/1567347233996.png)

### 分类

![1567347272755](https://github.com/lqc520/HomeMall/blob/master/assess/1567347272755.png)

![1567347293490](https://github.com/lqc520/HomeMall/blob/master/assess/1567347293490.png)

### 详情页

![1567347324586](https://github.com/lqc520/HomeMall/blob/master/assess/1567347324586.png)

### 收藏商品

![1567347388074](https://github.com/lqc520/HomeMall/blob/master/assess/1567347388074.png)

### cookie购物车

![1567347439663](https://github.com/lqc520/HomeMall/blob/master/assess/1567347439663.png)



### 支付

![1566923065537](https://github.com/lqc520/HomeMall/blob/master/assess/1566923065537.png)

![1566922163659](https://github.com/lqc520/HomeMall/blob/master/assess/1566922163659.png)

### 买家支付宝

![buyer](https://github.com/lqc520/HomeMall/blob/master/assess/buyer.jpg)

### 卖家支付宝

![buyer](https://github.com/lqc520/HomeMall/blob/master/assess/seller.jpg)

### 登录/注册

### ![1567347457658](https://github.com/lqc520/HomeMall/blob/master/assess/1567347457658.png)

### 短信验证码

![sms](https://github.com/lqc520/HomeMall/blob/master/assess/sms.jpg)

### 编辑地址

![1567347782005](https://github.com/lqc520/HomeMall/blob/master/assess/1567347782005.png)

### 我的收藏

![1567347804107](https://github.com/lqc520/HomeMall/blob/master/assess/1567347804107.png)

### 订单中心

![1567347839153](https://github.com/lqc520/HomeMall/blob/master/assess/1567347839153.png)

## 商城后台图片

## 后台登录

![1567348624789](https://github.com/lqc520/HomeMall/blob/master/assess/1567348624789.png)

### 后台注册

![1567348725470](https://github.com/lqc520/HomeMall/blob/master/assess/1567348725470.png)

### 忘记密码

### ![1567348829818](https://github.com/lqc520/HomeMall/blob/master/assess/1567348829818.png)

### 重置密码

![1567348881901](https://github.com/lqc520/HomeMall/blob/master/assess/1567348881901.png)

### 控制台

![1567348928985](https://github.com/lqc520/HomeMall/blob/master/assess/1567348928985.png)

### 订单列表

![1567348953198](https://github.com/lqc520/HomeMall/blob/master/assess/1567348953198.png)

### 支付查询

![1567348967459](https://github.com/lqc520/HomeMall/blob/master/assess/1567348967459.png)

### 商品列表

![1567348996717](https://github.com/lqc520/HomeMall/blob/master/assess/1567348996717.png)

### 编辑

![1567349017476](https://github.com/lqc520/HomeMall/blob/master/assess/1567349017476.png)

### 服务器控制台

![1567349088729](https://github.com/lqc520/HomeMall/blob/master/assess/1567349088729.png)

等等

## 小程序端图片

### 首页

![1567663645859](https://github.com/lqc520/HomeMall/blob/master/assess/1567663645859.png)

![1567663717633](https://github.com/lqc520/HomeMall/blob/master/assess/1567663717633.png)

### 详情页

![1567663804783](https://github.com/lqc520/HomeMall/blob/master/assess/1567663804783.png)

### 搜索

![1567663865908](https://github.com/lqc520/HomeMall/blob/master/assess/1567663865908.png)

![1567663959172](https://github.com/lqc520/HomeMall/blob/master/assess/1567663959172.png)

### 

### 分类

![sort](https://github.com/lqc520/HomeMall/blob/master/assess/1567664008706.png)



### 床品

![1567664072729](https://github.com/lqc520/HomeMall/blob/master/assess/1567664072729.png)

### 购物车

![1567664126030](https://github.com/lqc520/HomeMall/blob/master/assess/1567664126030.png)

### 订单

![1567664188054](https://github.com/lqc520/HomeMall/blob/master/assess/1567664188054.png)

### 我的

![1567664226284](https://github.com/lqc520/HomeMall/blob/master/assess/1567664226284.png)

# 项目服务器部署

```linux
nohup java -jar mallv2.jar >mallv2.out 2>&1
```

```
netstat -tunlp|grep {port}
ps -ef | grep {programName}
pgrep {programName}
kill -9 {PID}
```



# 技术要点实现

## cookie购物车构思

# 技术点记录

## REST 自动封装Map

```java
@ApiOperation(value = "测试")
    @GetMapping("/getPageList/{pageNum}/{pageSize}/{categoryId}/{sortId}/{orderType}/{byOrder}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "当前页",paramType = "path"),
            @ApiImplicitParam(name = "pageSize",value = "分页条数",paramType = "path"),
            @ApiImplicitParam(name = "categoryId",value = "分类id",paramType = "path"),
            @ApiImplicitParam(name = "sortId",value = "二级类别id",paramType = "path"),
            @ApiImplicitParam(name = "orderType",value = "时间|价格",paramType = "path"),
            @ApiImplicitParam(name = "byOrder",value = "ASC|DESC",paramType = "path"),
    })
    public Map getMyPageList(@PathVariable Map map)
    {
        return map;
//        return goodsService.getPageList(new HashMap(),pageNum,pageNum).getList();
    }
```

response

```java
{
  "pageNum": "1",
  "pageSize": "1",
  "categoryId": "1",
  "sortId": "1",
  "orderType": "1",
  "byOrder": "asc"
}
```



## Vue

### Axios请求api接口

```vue
 var main=new Vue({
    el:'#main',
    data () {
      return {
        items: []
      }
    },
    mounted(){
      axios.get("http://localhost:8080/list")
              .then(response => (this.items = response.data))
              .catch(error => console.log(error))
    }
  })
```

### 标签内部要用绑定 	:src="v.img"

```vue
<div class="layui-col-xs6 layui-col-sm3" v-for="(v,i) in items">
      <div class="list-detail">
        <div class="img"><img :src="v.img"></div>
        <p class="title"><a href="detail.html">{{v.name}}</a></p>
        <p><span class="price">￥{{v.price}}</span><span>1266</span>人付款</p>
      </div>
    </div>
```

### detail

```vue
<script>
  function getQueryVariable(variable)
  {
    const query = window.location.search.substring(1);
    const vars = query.split("&");
    for (let i=0;i<vars.length;i++) {
      let pair = vars[i].split("=");
      if(pair[0] === variable){return pair[1];}
    }
    return(false);
  }
  console.log(getQueryVariable("id"));
  new Vue({
    el:"#main",
    data() {
      return {
        id:getQueryVariable("id"),
        goods:{},
        detailImg:[],
        card:{id:'',name:'',img:'',price:'',count:1},
        cardsInfo:this.$cookies.get("cards"),
        cards:[]
      };
    },mounted(){
        axios.get(`http://localhost:8080/api/goods/getById/${this.id}`).then(
                response => {
                  this.goods = response.data;
                  this.detailImg = response.data.detailImg.split(",");
                }

        );
    },methods:{
      addCard:function () {
        if(this.$cookies.isKey("cards")&&this.$cookies.get("cards")!=null){//判断有没有购物车
          let strCards=this.$cookies.get("cards");
          let jsonCards=JSON.parse(strCards);
          this.cards=jsonCards;//更新当前用户购物车列表
          console.log("jsonCards",jsonCards);
          let flag=false;//判断新添加的商品有没有在购物车里面
          for(let i=0;i<jsonCards.length ;i++){
            if(jsonCards[i].id===this.goods.id){
              flag=true;//商品有在购物车里面
              jsonCards[i].count = (jsonCards[i].count+this.card.count)<this.goods.stock? jsonCards[i].count += this.card.count:this.goods.stock;
              if(jsonCards[i].count>=this.goods.stock){
                layer.msg("已超出库存数量！");
              }
              console.log("jsonCards[i].count"+jsonCards[i].count);
              break;
            }
          }
          if(!flag){//商品没有在购物车里面 添加新商品
            this.card.id=this.goods.id;
            this.card.name=this.goods.name;
            this.card.img=this.goods.img;
            this.card.price=this.goods.price;
            this.cards.push(this.card);
          }
          this.$cookies.set("cards",JSON.stringify(jsonCards));//更新购物车
        }else {//第一次添加cookie 第一件商品加入购物车
          this.card.id=this.goods.id;
          this.card.name=this.goods.name;
          this.card.img=this.goods.img;
          this.card.price=this.goods.price;
          this.cards.push(this.card);
          this.$cookies.set("cards",JSON.stringify(this.cards));//更新购物车 序列化成字符串
        }
      },
      plus:function () {
        // this.count = this.count < this.goods.stock ? this.count+=1:this.goods.stock;
        this.card.count = this.card.count < this.goods.stock ? this.card.count+=1:this.goods.stock;
        if(this.card.count>=this.goods.stock){
          layer.msg("已超出库存数量！");
        }
      },
      reduce:function () {
        this. card.count=this. card.count>1?this. card.count-=1:1;
        // this.count=this.count>1?this.count-=1:1;
      }
    },watch:{
      goods:val => console.log(val),
      detailImg:val => console.log(val),
      cardInfo:val => console.log(val),
      cards:val =>  console.log(val),
      'card.count' : val=>console.log(val)
    }
  });

</script>
```

## javaScript

### 获取url参数

```js
function getQueryVariable(variable)
  {
    const query = window.location.search.substring(1);
    const vars = query.split("&");
    for (let i=0;i<vars.length;i++) {
      let pair = vars[i].split("=");
      if(pair[0] == variable){return pair[1];}
    }
    return(false);
  }
  console.log(getQueryVariable("id"));
```

### 获取cookie

```
  function getMyCookie(key) {
    var val = "";

    // 对cookie操作
    var cookies = document.cookie;
    cookies = cookies.replace(/\s/, "");
    var cookie_array = cookies.split(";");
    for (i = 0; i < cookie_array.length; i++) {
      // yh_mch=lilei
      var cookie = cookie_array[i];
      var array = cookie.split("=");
      if (array[0] == key) {
        val = array[1];
      }
    }

    return val;
  }
  console.log(getMyCookie("token"));
```



### cookie购物车

```
addCard:function () {
        if(this.$cookies.isKey("cards")&&this.$cookies.get("cards")!=null){//判断有没有购物车
          let strCards=this.$cookies.get("cards");
          let jsonCards=JSON.parse(strCards);
          this.cards=jsonCards;//更新当前用户购物车列表
          console.log("jsonCards",jsonCards);
          let flag=false;//判断新添加的商品有没有在购物车里面
          for(let i=0;i<jsonCards.length ;i++){
            if(jsonCards[i].id===this.goods.id){
              flag=true;//商品有在购物车里面
              jsonCards[i].count = (jsonCards[i].count+this.card.count)<this.goods.stock? jsonCards[i].count += this.card.count:this.goods.stock;
              if(jsonCards[i].count>=this.goods.stock){
                layer.msg("已超出库存数量！");
              }
              console.log("jsonCards[i].count"+jsonCards[i].count);
              break;
            }
          }
          if(!flag){//商品没有在购物车里面 添加新商品
            this.card.id=this.goods.id;
            this.card.name=this.goods.name;
            this.card.img=this.goods.img;
            this.card.price=this.goods.price;
            this.cards.push(this.card);
          }
          this.$cookies.set("cards",JSON.stringify(jsonCards));//更新购物车
        }else {//第一次添加cookie 第一件商品加入购物车
          this.card.id=this.goods.id;
          this.card.name=this.goods.name;
          this.card.img=this.goods.img;
          this.card.price=this.goods.price;
          this.cards.push(this.card);
          this.$cookies.set("cards",JSON.stringify(this.cards));//更新购物车 序列化成字符串
        }
      },
```



# BUG记录

## springboot记录

### @MapperScan 要在@SpringBootApplication之前

```java
package cn.lqcnb.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;
@MapperScan("cn.lqcnb.mall.api.mapper")
@SpringBootApplication
public class MallApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class, args);
    }

}
```

## Mybatis记录

### if 一个参数

```sql
 <select id="getProductByName" resultType="map" parameterType="String">
        SELECT
            *
        FROM
            hotproduct
            <where>
                <if test="_parameter!=null and _parameter!='' ">
                    NAME LIKE CONCAT("%",#{name},"%")
                </if>
            </where>
    </select>
```

### order by asc|desc 用 $ #识别不出来

```sql
 <select id="getPageList" parameterType="map" resultType="cn.lqcnb.mall.api.entity.Goods">
      SELECT
          *
      FROM
          `mall_goods`
      <where>
        <if test="categoryId != null and categoryId != '' and categoryId !=0 ">
            and  category_id=#{categoryId}
        </if>
        <if test="sortId != null and sortId !='' and sortId !=0 ">
            and sort_id=#{sortId}
        </if>
        <if test="seasonId != null and seasonId !='' and seasonId !=0 ">
            and season_id=#{seasonId}
        </if>
      </where>
            
      <if test="orderType != null and orderType!= '' and orderType == 'byTime' and  byOrder != null and byOrder != '' ">
           order by create_time ${byOrder}
      </if>

      <if test="orderType != null and orderType!='' and orderType == 'byPrice' and  byOrder != null and byOrder != ''">
           order by price ${byOrder}
      </if>

    </select>
```

### 参数不能为0 会未定义

```sql
 <select id="getPageList" parameterType="map" resultType="cn.lqcnb.mall.api.entity.Goods">
      SELECT
          *
      FROM
          `mall_goods`
      <where>
        <if test="categoryId != null and categoryId != '' and categoryId !=-1 ">
            and  category_id=#{categoryId}
        </if>
        <if test="sortId != null and sortId !='' and sortId !=-1 ">
            and sort_id=#{sortId}
        </if>
        <if test="seasonId != null and seasonId !='' and seasonId !=-1 ">
            and season_id=#{seasonId}
        </if>
      </where>

      <if test="orderType != null and orderType!= '' and orderType == 'byTime' and  byOrder != null and byOrder != '' ">
             order by create_time ${byOrder}
      </if>

      <if test="orderType != null and orderType!='' and orderType == 'byPrice' and  byOrder != null and byOrder != ''">
             order by price ${byOrder}
      </if>

    </select>
```

### mybatis in $			 #识别不出来

```
@Select("select id,name,img avatar,price from mall_goods where id in(${ids})")
```




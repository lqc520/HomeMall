package cn.lqcnb.mall.api.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_card")
public class Card {
    @Id
    private Integer id;

    @Column(name = "member_id")
    private Integer memberId;

    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 颜色
     */
    private String color;

    /**
     * 图片
     */
    private String avatar;

    /**
     * 数量
     */
    private String number;

    /**
     * 价格
     */
    private String price;

    /**
     * 原价
     */
    private BigDecimal original;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;
    private Integer stock;

    public Card() {
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", goodsId=" + goodsId +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", avatar='" + avatar + '\'' +
                ", number='" + number + '\'' +
                ", price='" + price + '\'' +
                ", original=" + original +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", stock=" + stock +
                '}';
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return member_id
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * @param memberId
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * @return goods_id
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取商品名称
     *
     * @return name - 商品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置商品名称
     *
     * @param name 商品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取颜色
     *
     * @return color - 颜色
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置颜色
     *
     * @param color 颜色
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 获取图片
     *
     * @return avatar - 图片
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置图片
     *
     * @param avatar 图片
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取数量
     *
     * @return number - 数量
     */
    public String getNumber() {
        return number;
    }

    /**
     * 设置数量
     *
     * @param number 数量
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * 获取价格
     *
     * @return price - 价格
     */
    public String getPrice() {
        return price;
    }

    /**
     * 设置价格
     *
     * @param price 价格
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * 获取原价
     *
     * @return original - 原价
     */
    public BigDecimal getOriginal() {
        return original;
    }

    /**
     * 设置原价
     *
     * @param original 原价
     */
    public void setOriginal(BigDecimal original) {
        this.original = original;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
package cn.lqcnb.mall.api.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_order_item")
public class OrderItem {
    @Id
    private Integer id;

    /**
     * 订单id
     */
    @Column(name = "order_number")
    private String orderNumber;

    /**
     * 商品id
     */
    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * 商品名称
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * 商品图片
     */
    @Column(name = "goods_img")
    private String goodsImg;

    /**
     * 商品颜色
     */
    @Column(name = "goods_color")
    private String goodsColor;

    /**
     * 生成订单时的商品单价
     */
    @Column(name = "goods_price")
    private double goodsPrice;

    /**
     * 商品数量
     */
    private Integer quantity;

    /**
     * 是否删除 0正常  1删除
     */
    @Column(name = "is_delete")
    private Integer isDelete;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    public OrderItem() {
    }

    public OrderItem(String orderNumber, Integer goodsId, String goodsName, String goodsImg, String goodsColor, double goodsPrice, Integer quantity) {
        this.orderNumber = orderNumber;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsImg = goodsImg;
        this.goodsColor = goodsColor;
        this.goodsPrice = goodsPrice;
        this.quantity = quantity;
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
     * 获取订单id
     *
     * @return order_number - 订单id
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置订单id
     *
     * @param orderNumber 订单id
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * 获取商品id
     *
     * @return goods_id - 商品id
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 设置商品id
     *
     * @param goodsId 商品id
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取商品名称
     *
     * @return goods_name - 商品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置商品名称
     *
     * @param goodsName 商品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * 获取商品图片
     *
     * @return goods_img - 商品图片
     */
    public String getGoodsImg() {
        return goodsImg;
    }

    /**
     * 设置商品图片
     *
     * @param goodsImg 商品图片
     */
    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    /**
     * 获取商品颜色
     *
     * @return goods_color - 商品颜色
     */
    public String getGoodsColor() {
        return goodsColor;
    }

    /**
     * 设置商品颜色
     *
     * @param goodsColor 商品颜色
     */
    public void setGoodsColor(String goodsColor) {
        this.goodsColor = goodsColor;
    }

    /**
     * 获取生成订单时的商品单价
     *
     * @return goods_price - 生成订单时的商品单价
     */
    public double getGoodsPrice() {
        return goodsPrice;
    }

    /**
     * 设置生成订单时的商品单价
     *
     * @param goodsPrice 生成订单时的商品单价
     */
    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    /**
     * 获取商品数量
     *
     * @return quantity - 商品数量
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 设置商品数量
     *
     * @param quantity 商品数量
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * 获取是否删除 0正常  1删除
     *
     * @return is_delete - 是否删除 0正常  1删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除 0正常  1删除
     *
     * @param isDelete 是否删除 0正常  1删除
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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
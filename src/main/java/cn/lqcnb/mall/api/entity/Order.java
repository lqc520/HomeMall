package cn.lqcnb.mall.api.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_order")
public class Order {
    public Order() {
    }

  

    /**
     * 订单编号
     */
    @Id
    @Column(name = "order_number")
    private String orderNumber;

    /**
     * 下单用户
     */
    @Column(name = "member_id")
    private Integer memberId;

    /**
     * 收货地址
     */
    @Column(name = "address_id")
    private Integer addressId;

    /**
     * 应付金额
     */
    @Column(name = "payment_amount")
    private double paymentAmount;

    /**
     * 支付时间
     */
    @Column(name = "payment_time")
    private Date paymentTime;

    /**
     * 商品运费
     */
    private double freight;

    /**
     * 发货时间
     */
    @Column(name = "send_time")
    private Date sendTime;

    /**
     * 交易完成时间
     */
    @Column(name = "finish_time")
    private Date finishTime;

    /**
     * 交易关闭时间
     */
    @Column(name = "cancel_time")
    private Date cancelTime;

    /**
     * 订单状态 
0 待支付 
1 待发货 
2 待收货 
3 待评价 
4 已完成
5 交易关闭
     */
    @Column(name = "order_status")
    private Integer orderStatus;

    /**
     * 是否删除 0正常 1删除
     */
    @Column(name = "is_delete")
    private Integer isDelete;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取订单编号
     *
     * @return order_number - 订单编号
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置订单编号
     *
     * @param orderNumber 订单编号
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * 获取下单用户
     *
     * @return member_id - 下单用户
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 设置下单用户
     *
     * @param memberId 下单用户
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * 获取收货地址
     *
     * @return address_id - 收货地址
     */
    public Integer getAddressId() {
        return addressId;
    }

    /**
     * 设置收货地址
     *
     * @param addressId 收货地址
     */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    /**
     * 获取应付金额
     *
     * @return payment_amount - 应付金额
     */
    public double getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * 设置应付金额
     *
     * @param paymentAmount 应付金额
     */
    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    /**
     * 获取支付时间
     *
     * @return payment_time - 支付时间
     */
    public Date getPaymentTime() {
        return paymentTime;
    }

    /**
     * 设置支付时间
     *
     * @param paymentTime 支付时间
     */
    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    /**
     * 获取商品运费
     *
     * @return freight - 商品运费
     */
    public double getFreight() {
        return freight;
    }

    /**
     * 设置商品运费
     *
     * @param freight 商品运费
     */
    public void setFreight(double freight) {
        this.freight = freight;
    }

    /**
     * 获取发货时间
     *
     * @return send_time - 发货时间
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * 设置发货时间
     *
     * @param sendTime 发货时间
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * 获取交易完成时间
     *
     * @return finish_time - 交易完成时间
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * 设置交易完成时间
     *
     * @param finishTime 交易完成时间
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 获取交易关闭时间
     *
     * @return cancel_time - 交易关闭时间
     */
    public Date getCancelTime() {
        return cancelTime;
    }

    /**
     * 设置交易关闭时间
     *
     * @param cancelTime 交易关闭时间
     */
    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    /**
     * 获取订单状态 
0 待支付 
1 待发货 
2 待收货 
3 待评价 
4 已完成
5 交易关闭
     *
     * @return order_status - 订单状态 
0 待支付 
1 待发货 
2 待收货 
3 待评价 
4 已完成
5 交易关闭
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置订单状态 
0 待支付 
1 待发货 
2 待收货 
3 待评价 
4 已完成
5 交易关闭
     *
     * @param orderStatus 订单状态 
0 待支付 
1 待发货 
2 待收货 
3 待评价 
4 已完成
5 交易关闭
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 获取是否删除 0正常 1删除
     *
     * @return is_delete - 是否删除 0正常 1删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除 0正常 1删除
     *
     * @param isDelete 是否删除 0正常 1删除
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
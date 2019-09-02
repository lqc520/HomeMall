package cn.lqcnb.mall.api.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_payment")
public class Payment {
    @Id
    private Integer id;

    /**
     * 买家ID
     */
    @Column(name = "member_id")
    private Integer memberId;

    /**
     * 订单编号
     */
    @Column(name = "order_number")
    private String orderNumber;

    /**
     * 付款方式 1支付宝 2微信支付 
     */
    @Column(name = "payment_type")
    private Integer paymentType;

    /**
     * 交易流水号
     */
    @Column(name = "payment_number")
    private String paymentNumber;

    /**
     * 交易金额
     */
    @Column(name = "payment_amount")
    private double paymentAmount;

    /**
     * 支付状态
0待支付 
1已支付 
2待退款 
3已退款 
4交易关闭
     */
    @Column(name = "payment_status")
    private Integer paymentStatus;

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
     * 获取买家ID
     *
     * @return member_id - 买家ID
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 设置买家ID
     *
     * @param memberId 买家ID
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

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
     * 获取付款方式 1支付宝 2微信支付 
     *
     * @return payment_type - 付款方式 1支付宝 2微信支付 
     */
    public Integer getPaymentType() {
        return paymentType;
    }

    /**
     * 设置付款方式 1支付宝 2微信支付 
     *
     * @param paymentType 付款方式 1支付宝 2微信支付 
     */
    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * 获取交易流水号
     *
     * @return payment_number - 交易流水号
     */
    public String getPaymentNumber() {
        return paymentNumber;
    }

    /**
     * 设置交易流水号
     *
     * @param paymentNumber 交易流水号
     */
    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    /**
     * 获取交易金额
     *
     * @return payment_amount - 交易金额
     */
    public double getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * 设置交易金额
     *
     * @param paymentAmount 交易金额
     */
    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    /**
     * 获取支付状态
0待支付 
1已支付 
2待退款 
3已退款 
4交易关闭
     *
     * @return payment_status - 支付状态
0待支付 
1已支付 
2待退款 
3已退款 
4交易关闭
     */
    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * 设置支付状态
0待支付 
1已支付 
2待退款 
3已退款 
4交易关闭
     *
     * @param paymentStatus 支付状态
0待支付 
1已支付 
2待退款 
3已退款 
4交易关闭
     */
    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
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
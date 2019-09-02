package cn.lqcnb.mall.api.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_goods")
public class Goods {
    @Id
    private Integer id;

    /**
     * 商品分类id
     */
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "sort_id")
    private Integer sortId;

    /**
     * 季节id 不是所有产品都有季节 1 2 3 4
     */
    @Column(name = "season_id")
    private Integer seasonId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品简介
     */
    private String introduce;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 运费
     */
    private BigDecimal freight;

    /**
     * 商品主图片 网站商品列表展示使用
     */
    private String img;

    /**
     * 商品状态 0上架   1下架
     */
    private Integer status;

    /**
     * 是否删除 0正常  1删除
     */
    @Column(name = "is_delete")
    private Integer isDelete;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 商品详情的图片 可以是多张图片
     */
    @Column(name = "detail_img")
    private String detailImg;

    /**
     * 商品详情
     */
    private String detail;

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
     * 获取商品分类id
     *
     * @return category_id - 商品分类id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置商品分类id
     *
     * @param categoryId 商品分类id
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return sort_id
     */
    public Integer getSortId() {
        return sortId;
    }

    /**
     * @param sortId
     */
    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    /**
     * 获取季节id 不是所有产品都有季节 1 2 3 4
     *
     * @return season_id - 季节id 不是所有产品都有季节 1 2 3 4
     */
    public Integer getSeasonId() {
        return seasonId;
    }

    /**
     * 设置季节id 不是所有产品都有季节 1 2 3 4
     *
     * @param seasonId 季节id 不是所有产品都有季节 1 2 3 4
     */
    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
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
     * 获取商品简介
     *
     * @return introduce - 商品简介
     */
    public String getIntroduce() {
        return introduce;
    }

    /**
     * 设置商品简介
     *
     * @param introduce 商品简介
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    /**
     * 获取商品价格
     *
     * @return price - 商品价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置商品价格
     *
     * @param price 商品价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取库存
     *
     * @return stock - 库存
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 设置库存
     *
     * @param stock 库存
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 获取运费
     *
     * @return freight - 运费
     */
    public BigDecimal getFreight() {
        return freight;
    }

    /**
     * 设置运费
     *
     * @param freight 运费
     */
    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    /**
     * 获取商品主图片 网站商品列表展示使用
     *
     * @return img - 商品主图片 网站商品列表展示使用
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置商品主图片 网站商品列表展示使用
     *
     * @param img 商品主图片 网站商品列表展示使用
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 获取商品状态 0上架   1下架
     *
     * @return status - 商品状态 0上架   1下架
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置商品状态 0上架   1下架
     *
     * @param status 商品状态 0上架   1下架
     */
    public void setStatus(Integer status) {
        this.status = status;
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

    /**
     * 获取商品详情的图片 可以是多张图片
     *
     * @return detail_img - 商品详情的图片 可以是多张图片
     */
    public String getDetailImg() {
        return detailImg;
    }

    /**
     * 设置商品详情的图片 可以是多张图片
     *
     * @param detailImg 商品详情的图片 可以是多张图片
     */
    public void setDetailImg(String detailImg) {
        this.detailImg = detailImg;
    }

    /**
     * 获取商品详情
     *
     * @return detail - 商品详情
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置商品详情
     *
     * @param detail 商品详情
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }
}
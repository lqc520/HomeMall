package cn.lqcnb.mall.api.entity;

import javax.persistence.*;

@Table(name = "mall_comment")
public class Comment {
    @Id
    private Integer id;

    @Column(name = "member_id")
    private Integer memberId;

    @Column(name = "goods_id")
    private Integer goodsId;

    private String content;

    private String star;

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
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return star
     */
    public String getStar() {
        return star;
    }

    /**
     * @param star
     */
    public void setStar(String star) {
        this.star = star;
    }
}
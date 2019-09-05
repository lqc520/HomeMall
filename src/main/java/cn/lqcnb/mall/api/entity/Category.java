package cn.lqcnb.mall.api.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_category")
public class Category {
    @Id
    private Integer id;

    /**
     * 类目名称
     */
    private String name;

    /**
     * 类目在楼层展示中的图片
     */
    private String img;

    /**
     * 展示顺序
     */
    private Integer sort;

    private String wid;

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
     * 获取类目名称
     *
     * @return name - 类目名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置类目名称
     *
     * @param name 类目名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取类目在楼层展示中的图片
     *
     * @return img - 类目在楼层展示中的图片
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置类目在楼层展示中的图片
     *
     * @param img 类目在楼层展示中的图片
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 获取展示顺序
     *
     * @return sort - 展示顺序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置展示顺序
     *
     * @param sort 展示顺序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * @return wid
     */
    public String getWid() {
        return wid;
    }

    /**
     * @param wid
     */
    public void setWid(String wid) {
        this.wid = wid;
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
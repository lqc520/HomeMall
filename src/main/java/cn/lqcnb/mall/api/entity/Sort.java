package cn.lqcnb.mall.api.entity;

import javax.persistence.*;

@Table(name = "mall_sort")
public class Sort {
    @Id
    private Integer id;

    /**
     * 小分类名称
     */
    private String name;

    private String img;

    /**
     * 大分类id
     */
    @Column(name = "category_id")
    private Integer categoryId;

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
     * 获取小分类名称
     *
     * @return name - 小分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置小分类名称
     *
     * @param name 小分类名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 获取大分类id
     *
     * @return category_id - 大分类id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置大分类id
     *
     * @param categoryId 大分类id
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
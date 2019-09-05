package cn.lqcnb.mall.api.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_member")
public class Member {
    @Id
    private Integer id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String avatar;

    private String mobile;

    /**
     * 是否激活  0激活  1未激活
     */
    @Column(name = "is_activate")
    private Integer isActivate;

    /**
     * 是否删除 0正常   1删除
     */
    @Column(name = "is_delete")
    private Integer isDelete;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
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
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取头像
     *
     * @return avatar - 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取是否激活  0激活  1未激活
     *
     * @return is_activate - 是否激活  0激活  1未激活
     */
    public Integer getIsActivate() {
        return isActivate;
    }

    /**
     * 设置是否激活  0激活  1未激活
     *
     * @param isActivate 是否激活  0激活  1未激活
     */
    public void setIsActivate(Integer isActivate) {
        this.isActivate = isActivate;
    }

    /**
     * 获取是否删除 0正常   1删除
     *
     * @return is_delete - 是否删除 0正常   1删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除 0正常   1删除
     *
     * @param isDelete 是否删除 0正常   1删除
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
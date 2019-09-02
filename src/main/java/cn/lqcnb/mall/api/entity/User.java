package cn.lqcnb.mall.api.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class User {
    @Id
    private Integer id;

    /**
     * 用户名
     */
    private String mobile;

    private String password;

    private String email;

    /**
     * 0 激活 1 未激活
     */
    private Integer state;

    /**
     * 头像
     */
    private String avatar;

    private String nickname;

    /**
     * 0 正常   1删除
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
     * 获取用户名
     *
     * @return mobile - 用户名
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置用户名
     *
     * @param mobile 用户名
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取0 激活 1 未激活
     *
     * @return state - 0 激活 1 未激活
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置0 激活 1 未激活
     *
     * @param state 0 激活 1 未激活
     */
    public void setState(Integer state) {
        this.state = state;
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
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取0 正常   1删除
     *
     * @return is_delete - 0 正常   1删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 设置0 正常   1删除
     *
     * @param isDelete 0 正常   1删除
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
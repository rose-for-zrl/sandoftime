package com.zrl.modules.api.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 在时间之沙网站注册用户信息
 * </p>
 *
 * @author rose
 * @since 2018-09-14
 */
@TableName("customer_info")
public class CustomerInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId("user_id")
    private String userId;
    /**
     * 真实姓名
     */
    @TableField("real_name")
    private String realName;
    /**
     * 用户显示名称
     */
    @TableField("nick_name")
    private String nickName;
    /**
     * 密码
     */
    private String password;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 身份证号码
     */
    @TableField("cert_no")
    private String certNo;
    /**
     * 性别
1:男
2:女
     */
    private String sex;
    /**
     * 地址
     */
    private String address;
    /**
     * 用户所在省
     */
    private String province;
    /**
     * 用户所在城市
     */
    private String city;
    /**
     * 创建时间
     */
    @TableField("insert_time")
    private Date insertTime;
    /**
     * 最近修改时间
     */
    @TableField("update_time")
    private Date updateTime;
    /**
     * 1：有效
0：无效
     */
    private String state;
    /**
     * 账号角色
     */
    private String role;
    /**
     * 权限,逗号分隔
     */
    private String permission;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" +
        ", userId=" + userId +
        ", realName=" + realName +
        ", nickName=" + nickName +
        ", password=" + password +
        ", birthday=" + birthday +
        ", certNo=" + certNo +
        ", sex=" + sex +
        ", address=" + address +
        ", province=" + province +
        ", city=" + city +
        ", insertTime=" + insertTime +
        ", updateTime=" + updateTime +
        ", state=" + state +
        ", role=" + role +
        ", permission=" + permission +
        "}";
    }
}

package com.zrl.modules.api.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 注册客户绑定信息
 * </p>
 *
 * @author rose
 * @since 2018-09-15
 */
@TableName("customer_binding_info")
public class CustomerBindingInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 注册用户的id,外键
     */
    @TableField("customer_info_id")
    private String customerInfoId;
    /**
     * 绑定类型(手机号、邮箱、身份证号码)
     */
    @TableField("binding_type")
    private String bindingType;
    /**
     * 绑定状态(是否)
     */
    @TableField("binding_state")
    private Integer bindingState;
    /**
     * 存储相应类型的值(手机号、身份证号码、邮箱)
     */
    @TableField("binding_content")
    private String bindingContent;
    /**
     * 绑定时间
     */
    @TableField("insert_time")
    private Date insertTime;


    public String getCustomerInfoId() {
        return customerInfoId;
    }

    public void setCustomerInfoId(String customerInfoId) {
        this.customerInfoId = customerInfoId;
    }

    public String getBindingType() {
        return bindingType;
    }

    public void setBindingType(String bindingType) {
        this.bindingType = bindingType;
    }

    public Integer getBindingState() {
        return bindingState;
    }

    public void setBindingState(Integer bindingState) {
        this.bindingState = bindingState;
    }

    public String getBindingContent() {
        return bindingContent;
    }

    public void setBindingContent(String bindingContent) {
        this.bindingContent = bindingContent;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    @Override
    public String toString() {
        return "CustomerBindingInfo{" +
        ", customerInfoId=" + customerInfoId +
        ", bindingType=" + bindingType +
        ", bindingState=" + bindingState +
        ", bindingContent=" + bindingContent +
        ", insertTime=" + insertTime +
        "}";
    }
}

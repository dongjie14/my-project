package com.easyget.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_channel_payment_config")
public class TChannelPaymentConfig {
    /**
     * 主键ID
     */
    @Id
    private Integer id;

    /**
     * 渠道类型
     */
    @Column(name = "channel_type")
    private String channelType;

    /**
     * 渠道名称
     */
    @Column(name = "channel_name")
    private String channelName;

    /**
     * 渠道服务bean
     */
    @Column(name = "channel_server_bean")
    private String channelServerBean;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 放款额度
     */
    @Column(name = "loan_quota")
    private BigDecimal loanQuota;

    /**
     * 生效时间
     */
    @Column(name = "eff_time")
    private Date effTime;

    /**
     * 失效时间
     */
    @Column(name = "exp_time")
    private Date expTime;

    /**
     * 创建人
     */
    @Column(name = "create_account")
    private String createAccount;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改人
     */
    @Column(name = "update_account")
    private String updateAccount;

    /**
     * 时间戳
     */
    @Column(name = "tm_smp")
    private Date tmSmp;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取渠道类型
     *
     * @return channel_type - 渠道类型
     */
    public String getChannelType() {
        return channelType;
    }

    /**
     * 设置渠道类型
     *
     * @param channelType 渠道类型
     */
    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    /**
     * 获取渠道名称
     *
     * @return channel_name - 渠道名称
     */
    public String getChannelName() {
        return channelName;
    }

    /**
     * 设置渠道名称
     *
     * @param channelName 渠道名称
     */
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    /**
     * 获取渠道服务bean
     *
     * @return channel_server_bean - 渠道服务bean
     */
    public String getChannelServerBean() {
        return channelServerBean;
    }

    /**
     * 设置渠道服务bean
     *
     * @param channelServerBean 渠道服务bean
     */
    public void setChannelServerBean(String channelServerBean) {
        this.channelServerBean = channelServerBean;
    }

    /**
     * 获取优先级
     *
     * @return priority - 优先级
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 设置优先级
     *
     * @param priority 优先级
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 获取放款额度
     *
     * @return loan_quota - 放款额度
     */
    public BigDecimal getLoanQuota() {
        return loanQuota;
    }

    /**
     * 设置放款额度
     *
     * @param loanQuota 放款额度
     */
    public void setLoanQuota(BigDecimal loanQuota) {
        this.loanQuota = loanQuota;
    }

    /**
     * 获取生效时间
     *
     * @return eff_time - 生效时间
     */
    public Date getEffTime() {
        return effTime;
    }

    /**
     * 设置生效时间
     *
     * @param effTime 生效时间
     */
    public void setEffTime(Date effTime) {
        this.effTime = effTime;
    }

    /**
     * 获取失效时间
     *
     * @return exp_time - 失效时间
     */
    public Date getExpTime() {
        return expTime;
    }

    /**
     * 设置失效时间
     *
     * @param expTime 失效时间
     */
    public void setExpTime(Date expTime) {
        this.expTime = expTime;
    }

    /**
     * 获取创建人
     *
     * @return create_account - 创建人
     */
    public String getCreateAccount() {
        return createAccount;
    }

    /**
     * 设置创建人
     *
     * @param createAccount 创建人
     */
    public void setCreateAccount(String createAccount) {
        this.createAccount = createAccount;
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
     * 获取修改人
     *
     * @return update_account - 修改人
     */
    public String getUpdateAccount() {
        return updateAccount;
    }

    /**
     * 设置修改人
     *
     * @param updateAccount 修改人
     */
    public void setUpdateAccount(String updateAccount) {
        this.updateAccount = updateAccount;
    }

    /**
     * 获取时间戳
     *
     * @return tm_smp - 时间戳
     */
    public Date getTmSmp() {
        return tmSmp;
    }

    /**
     * 设置时间戳
     *
     * @param tmSmp 时间戳
     */
    public void setTmSmp(Date tmSmp) {
        this.tmSmp = tmSmp;
    }
}
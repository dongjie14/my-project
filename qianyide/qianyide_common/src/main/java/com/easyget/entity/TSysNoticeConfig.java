package com.easyget.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sys_notice_config")
public class TSysNoticeConfig {
    /**
     * 主键ID
     */
    @Id
    private Integer id;

    /**
     * 公告主题
     */
    @Column(name = "notice_title")
    private String noticeTitle;

    /**
     * 公告概述
     */
    @Column(name = "notice_desc")
    private String noticeDesc;

    /**
     * 公告URL
     */
    @Column(name = "notice_url")
    private String noticeUrl;

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
     * update_account
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
     * 获取公告主题
     *
     * @return notice_title - 公告主题
     */
    public String getNoticeTitle() {
        return noticeTitle;
    }

    /**
     * 设置公告主题
     *
     * @param noticeTitle 公告主题
     */
    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    /**
     * 获取公告概述
     *
     * @return notice_desc - 公告概述
     */
    public String getNoticeDesc() {
        return noticeDesc;
    }

    /**
     * 设置公告概述
     *
     * @param noticeDesc 公告概述
     */
    public void setNoticeDesc(String noticeDesc) {
        this.noticeDesc = noticeDesc;
    }

    /**
     * 获取公告URL
     *
     * @return notice_url - 公告URL
     */
    public String getNoticeUrl() {
        return noticeUrl;
    }

    /**
     * 设置公告URL
     *
     * @param noticeUrl 公告URL
     */
    public void setNoticeUrl(String noticeUrl) {
        this.noticeUrl = noticeUrl;
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
     * 获取update_account
     *
     * @return update_account - update_account
     */
    public String getUpdateAccount() {
        return updateAccount;
    }

    /**
     * 设置update_account
     *
     * @param updateAccount update_account
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
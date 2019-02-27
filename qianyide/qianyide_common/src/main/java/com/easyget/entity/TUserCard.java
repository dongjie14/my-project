package com.easyget.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user_card")
public class TUserCard {
    /**
     * 主键ID
     */
    @Id
    private Integer id;

    /**
     * 用户编号
     */
    @Column(name = "user_no")
    private String userNo;

    /**
     * 银行卡号
     */
    @Column(name = "bank_card_no")
    private String bankCardNo;

    /**
     * 银行编码
     */
    @Column(name = "bank_code")
    private String bankCode;

    /**
     * 银行名称
     */
    @Column(name = "bank_name")
    private String bankName;

    /**
     * 绑卡编号
     */
    @Column(name = "bind_id")
    private String bindId;

    /**
     * 绑卡状态：1-初始化，2-绑卡成功，3-绑卡失败
     */
    @Column(name = "bind_sts")
    private Integer bindSts;

    /**
     * 绑卡渠道
     */
    @Column(name = "bind_type")
    private Integer bindType;

    /**
     * 绑卡时间
     */
    @Column(name = "bind_time")
    private Date bindTime;

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
     * 获取用户编号
     *
     * @return user_no - 用户编号
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     * 设置用户编号
     *
     * @param userNo 用户编号
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    /**
     * 获取银行卡号
     *
     * @return bank_card_no - 银行卡号
     */
    public String getBankCardNo() {
        return bankCardNo;
    }

    /**
     * 设置银行卡号
     *
     * @param bankCardNo 银行卡号
     */
    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    /**
     * 获取银行编码
     *
     * @return bank_code - 银行编码
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * 设置银行编码
     *
     * @param bankCode 银行编码
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    /**
     * 获取银行名称
     *
     * @return bank_name - 银行名称
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置银行名称
     *
     * @param bankName 银行名称
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * 获取绑卡编号
     *
     * @return bind_id - 绑卡编号
     */
    public String getBindId() {
        return bindId;
    }

    /**
     * 设置绑卡编号
     *
     * @param bindId 绑卡编号
     */
    public void setBindId(String bindId) {
        this.bindId = bindId;
    }

    /**
     * 获取绑卡状态：1-初始化，2-绑卡成功，3-绑卡失败
     *
     * @return bind_sts - 绑卡状态：1-初始化，2-绑卡成功，3-绑卡失败
     */
    public Integer getBindSts() {
        return bindSts;
    }

    /**
     * 设置绑卡状态：1-初始化，2-绑卡成功，3-绑卡失败
     *
     * @param bindSts 绑卡状态：1-初始化，2-绑卡成功，3-绑卡失败
     */
    public void setBindSts(Integer bindSts) {
        this.bindSts = bindSts;
    }

    /**
     * 获取绑卡渠道
     *
     * @return bind_type - 绑卡渠道
     */
    public Integer getBindType() {
        return bindType;
    }

    /**
     * 设置绑卡渠道
     *
     * @param bindType 绑卡渠道
     */
    public void setBindType(Integer bindType) {
        this.bindType = bindType;
    }

    /**
     * 获取绑卡时间
     *
     * @return bind_time - 绑卡时间
     */
    public Date getBindTime() {
        return bindTime;
    }

    /**
     * 设置绑卡时间
     *
     * @param bindTime 绑卡时间
     */
    public void setBindTime(Date bindTime) {
        this.bindTime = bindTime;
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
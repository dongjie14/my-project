package com.easyget.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_pay_loan_jnl")
public class TPayLoanJnl {
    /**
     * 主键ID
     */
    @Id
    private Integer id;

    /**
     * 借款订单号
     */
    @Column(name = "borrow_ord_no")
    private String borrowOrdNo;

    /**
     * 放款流水号
     */
    @Column(name = "loan_jnl_no")
    private String loanJnlNo;

    /**
     * 用户编号
     */
    @Column(name = "user_no")
    private String userNo;

    /**
     * 用户姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户手机号
     */
    @Column(name = "user_phone")
    private String userPhone;

    /**
     * 身份证号
     */
    @Column(name = "user_id_no")
    private String userIdNo;

    /**
     * 收款银行卡号
     */
    @Column(name = "bank_card_no")
    private String bankCardNo;

    /**
     * 收款银行编码
     */
    @Column(name = "bank_code")
    private String bankCode;

    /**
     * 收款银行名称
     */
    @Column(name = "bank_name")
    private String bankName;

    /**
     * 第三方渠道商户号
     */
    @Column(name = "out_merc_id")
    private String outMercId;

    /**
     * 第三方渠道终端号
     */
    @Column(name = "out_term_id")
    private String outTermId;

    /**
     * 商户订单号
     */
    @Column(name = "merc_order_no")
    private String mercOrderNo;

    /**
     * 请求时间
     */
    @Column(name = "req_time")
    private Date reqTime;

    /**
     * 放款金额
     */
    @Column(name = "loan_amt")
    private BigDecimal loanAmt;

    /**
     * 放款状态：1-初始化，2-处理中，3-代付成功，4-代付失败
     */
    @Column(name = "loan_sts")
    private Integer loanSts;

    /**
     * 放款渠道
     */
    @Column(name = "loan_channel")
    private String loanChannel;

    /**
     * 返回状态
     */
    @Column(name = "rsp_sts")
    private String rspSts;

    /**
     * 返回码
     */
    @Column(name = "rsp_code")
    private String rspCode;

    /**
     * 返回信息
     */
    @Column(name = "rsp_smg")
    private String rspSmg;

    /**
     * 外部订单号
     */
    @Column(name = "out_order_no")
    private String outOrderNo;

    /**
     * 对账状态：1-未对账，2-对账成功，3-对账失败，4-我方有对方无，5-对方有我方无，6-金额差错
     */
    @Column(name = "acc_sts")
    private Integer accSts;

    /**
     * 放款时间
     */
    @Column(name = "loan_time")
    private Date loanTime;

    /**
     * 预留字段一
     */
    @Column(name = "reserve_field1")
    private String reserveField1;

    /**
     * 预留字段二
     */
    @Column(name = "reserve_field2")
    private String reserveField2;

    /**
     * 预留字段三
     */
    @Column(name = "reserve_field3")
    private String reserveField3;

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
     * 获取借款订单号
     *
     * @return borrow_ord_no - 借款订单号
     */
    public String getBorrowOrdNo() {
        return borrowOrdNo;
    }

    /**
     * 设置借款订单号
     *
     * @param borrowOrdNo 借款订单号
     */
    public void setBorrowOrdNo(String borrowOrdNo) {
        this.borrowOrdNo = borrowOrdNo;
    }

    /**
     * 获取放款流水号
     *
     * @return loan_jnl_no - 放款流水号
     */
    public String getLoanJnlNo() {
        return loanJnlNo;
    }

    /**
     * 设置放款流水号
     *
     * @param loanJnlNo 放款流水号
     */
    public void setLoanJnlNo(String loanJnlNo) {
        this.loanJnlNo = loanJnlNo;
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
     * 获取用户姓名
     *
     * @return user_name - 用户姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户姓名
     *
     * @param userName 用户姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户手机号
     *
     * @return user_phone - 用户手机号
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 设置用户手机号
     *
     * @param userPhone 用户手机号
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * 获取身份证号
     *
     * @return user_id_no - 身份证号
     */
    public String getUserIdNo() {
        return userIdNo;
    }

    /**
     * 设置身份证号
     *
     * @param userIdNo 身份证号
     */
    public void setUserIdNo(String userIdNo) {
        this.userIdNo = userIdNo;
    }

    /**
     * 获取收款银行卡号
     *
     * @return bank_card_no - 收款银行卡号
     */
    public String getBankCardNo() {
        return bankCardNo;
    }

    /**
     * 设置收款银行卡号
     *
     * @param bankCardNo 收款银行卡号
     */
    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    /**
     * 获取收款银行编码
     *
     * @return bank_code - 收款银行编码
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * 设置收款银行编码
     *
     * @param bankCode 收款银行编码
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    /**
     * 获取收款银行名称
     *
     * @return bank_name - 收款银行名称
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置收款银行名称
     *
     * @param bankName 收款银行名称
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * 获取第三方渠道商户号
     *
     * @return out_merc_id - 第三方渠道商户号
     */
    public String getOutMercId() {
        return outMercId;
    }

    /**
     * 设置第三方渠道商户号
     *
     * @param outMercId 第三方渠道商户号
     */
    public void setOutMercId(String outMercId) {
        this.outMercId = outMercId;
    }

    /**
     * 获取第三方渠道终端号
     *
     * @return out_term_id - 第三方渠道终端号
     */
    public String getOutTermId() {
        return outTermId;
    }

    /**
     * 设置第三方渠道终端号
     *
     * @param outTermId 第三方渠道终端号
     */
    public void setOutTermId(String outTermId) {
        this.outTermId = outTermId;
    }

    /**
     * 获取商户订单号
     *
     * @return merc_order_no - 商户订单号
     */
    public String getMercOrderNo() {
        return mercOrderNo;
    }

    /**
     * 设置商户订单号
     *
     * @param mercOrderNo 商户订单号
     */
    public void setMercOrderNo(String mercOrderNo) {
        this.mercOrderNo = mercOrderNo;
    }

    /**
     * 获取请求时间
     *
     * @return req_time - 请求时间
     */
    public Date getReqTime() {
        return reqTime;
    }

    /**
     * 设置请求时间
     *
     * @param reqTime 请求时间
     */
    public void setReqTime(Date reqTime) {
        this.reqTime = reqTime;
    }

    /**
     * 获取放款金额
     *
     * @return loan_amt - 放款金额
     */
    public BigDecimal getLoanAmt() {
        return loanAmt;
    }

    /**
     * 设置放款金额
     *
     * @param loanAmt 放款金额
     */
    public void setLoanAmt(BigDecimal loanAmt) {
        this.loanAmt = loanAmt;
    }

    /**
     * 获取放款状态：1-初始化，2-处理中，3-代付成功，4-代付失败
     *
     * @return loan_sts - 放款状态：1-初始化，2-处理中，3-代付成功，4-代付失败
     */
    public Integer getLoanSts() {
        return loanSts;
    }

    /**
     * 设置放款状态：1-初始化，2-处理中，3-代付成功，4-代付失败
     *
     * @param loanSts 放款状态：1-初始化，2-处理中，3-代付成功，4-代付失败
     */
    public void setLoanSts(Integer loanSts) {
        this.loanSts = loanSts;
    }

    /**
     * 获取放款渠道
     *
     * @return loan_channel - 放款渠道
     */
    public String getLoanChannel() {
        return loanChannel;
    }

    /**
     * 设置放款渠道
     *
     * @param loanChannel 放款渠道
     */
    public void setLoanChannel(String loanChannel) {
        this.loanChannel = loanChannel;
    }

    /**
     * 获取返回状态
     *
     * @return rsp_sts - 返回状态
     */
    public String getRspSts() {
        return rspSts;
    }

    /**
     * 设置返回状态
     *
     * @param rspSts 返回状态
     */
    public void setRspSts(String rspSts) {
        this.rspSts = rspSts;
    }

    /**
     * 获取返回码
     *
     * @return rsp_code - 返回码
     */
    public String getRspCode() {
        return rspCode;
    }

    /**
     * 设置返回码
     *
     * @param rspCode 返回码
     */
    public void setRspCode(String rspCode) {
        this.rspCode = rspCode;
    }

    /**
     * 获取返回信息
     *
     * @return rsp_smg - 返回信息
     */
    public String getRspSmg() {
        return rspSmg;
    }

    /**
     * 设置返回信息
     *
     * @param rspSmg 返回信息
     */
    public void setRspSmg(String rspSmg) {
        this.rspSmg = rspSmg;
    }

    /**
     * 获取外部订单号
     *
     * @return out_order_no - 外部订单号
     */
    public String getOutOrderNo() {
        return outOrderNo;
    }

    /**
     * 设置外部订单号
     *
     * @param outOrderNo 外部订单号
     */
    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    /**
     * 获取对账状态：1-未对账，2-对账成功，3-对账失败，4-我方有对方无，5-对方有我方无，6-金额差错
     *
     * @return acc_sts - 对账状态：1-未对账，2-对账成功，3-对账失败，4-我方有对方无，5-对方有我方无，6-金额差错
     */
    public Integer getAccSts() {
        return accSts;
    }

    /**
     * 设置对账状态：1-未对账，2-对账成功，3-对账失败，4-我方有对方无，5-对方有我方无，6-金额差错
     *
     * @param accSts 对账状态：1-未对账，2-对账成功，3-对账失败，4-我方有对方无，5-对方有我方无，6-金额差错
     */
    public void setAccSts(Integer accSts) {
        this.accSts = accSts;
    }

    /**
     * 获取放款时间
     *
     * @return loan_time - 放款时间
     */
    public Date getLoanTime() {
        return loanTime;
    }

    /**
     * 设置放款时间
     *
     * @param loanTime 放款时间
     */
    public void setLoanTime(Date loanTime) {
        this.loanTime = loanTime;
    }

    /**
     * 获取预留字段一
     *
     * @return reserve_field1 - 预留字段一
     */
    public String getReserveField1() {
        return reserveField1;
    }

    /**
     * 设置预留字段一
     *
     * @param reserveField1 预留字段一
     */
    public void setReserveField1(String reserveField1) {
        this.reserveField1 = reserveField1;
    }

    /**
     * 获取预留字段二
     *
     * @return reserve_field2 - 预留字段二
     */
    public String getReserveField2() {
        return reserveField2;
    }

    /**
     * 设置预留字段二
     *
     * @param reserveField2 预留字段二
     */
    public void setReserveField2(String reserveField2) {
        this.reserveField2 = reserveField2;
    }

    /**
     * 获取预留字段三
     *
     * @return reserve_field3 - 预留字段三
     */
    public String getReserveField3() {
        return reserveField3;
    }

    /**
     * 设置预留字段三
     *
     * @param reserveField3 预留字段三
     */
    public void setReserveField3(String reserveField3) {
        this.reserveField3 = reserveField3;
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
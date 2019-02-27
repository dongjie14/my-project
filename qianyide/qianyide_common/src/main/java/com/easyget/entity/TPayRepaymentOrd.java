package com.easyget.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_pay_repayment_ord")
public class TPayRepaymentOrd {
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
     * 还款订单号
     */
    @Column(name = "repayment_ord_no")
    private String repaymentOrdNo;

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
     * 还款期数
     */
    @Column(name = "repayment_period")
    private Integer repaymentPeriod;

    /**
     * 当前分期期数
     */
    @Column(name = "installment_num")
    private Integer installmentNum;

    /**
     * 应还本金
     */
    @Column(name = "repayment_amt")
    private BigDecimal repaymentAmt;

    /**
     * 应还利息
     */
    @Column(name = "repayment_fee")
    private BigDecimal repaymentFee;

    /**
     * 最后还款日
     */
    @Column(name = "repayment_end_date")
    private Date repaymentEndDate;

    /**
     * 还款周期：1-周，2-月
     */
    @Column(name = "repayment_cycle")
    private Integer repaymentCycle;

    /**
     * 还款状态：1-待还款，2-已逾期，3-已还款
     */
    @Column(name = "repayment_sts")
    private Integer repaymentSts;

    /**
     * 是否续期：0-否，1-是
     */
    @Column(name = "is_renewal")
    private Integer isRenewal;

    /**
     * 是否逾期：0-否，1-是
     */
    @Column(name = "is_overdue")
    private Integer isOverdue;

    /**
     * 已还款金额
     */
    @Column(name = "repaymented_amt")
    private BigDecimal repaymentedAmt;

    /**
     * 减免金额
     */
    @Column(name = "waiver_amount")
    private BigDecimal waiverAmount;

    /**
     * 逾期天数
     */
    @Column(name = "overdue_day")
    private Integer overdueDay;

    /**
     * 逾期费率（%）
     */
    @Column(name = "overdue_rate")
    private BigDecimal overdueRate;

    /**
     * 定额逾期费（元/天）
     */
    @Column(name = "overdue_fee")
    private BigDecimal overdueFee;

    /**
     * 逾期金额
     */
    @Column(name = "overdue_amt")
    private BigDecimal overdueAmt;

    /**
     * 还款完成时间
     */
    @Column(name = "repaymented_time")
    private Date repaymentedTime;

    /**
     * 还款渠道
     */
    @Column(name = "repayment_channel")
    private String repaymentChannel;

    /**
     * 还款银行卡号
     */
    @Column(name = "bank_card_no")
    private String bankCardNo;

    /**
     * 还款银行编码
     */
    @Column(name = "bank_code")
    private String bankCode;

    /**
     * 还款银行名称
     */
    @Column(name = "bank_name")
    private String bankName;

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
     * 更新操作员
     */
    @Column(name = "update_manage_name")
    private String updateManageName;

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
     * 获取还款订单号
     *
     * @return repayment_ord_no - 还款订单号
     */
    public String getRepaymentOrdNo() {
        return repaymentOrdNo;
    }

    /**
     * 设置还款订单号
     *
     * @param repaymentOrdNo 还款订单号
     */
    public void setRepaymentOrdNo(String repaymentOrdNo) {
        this.repaymentOrdNo = repaymentOrdNo;
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
     * 获取还款期数
     *
     * @return repayment_period - 还款期数
     */
    public Integer getRepaymentPeriod() {
        return repaymentPeriod;
    }

    /**
     * 设置还款期数
     *
     * @param repaymentPeriod 还款期数
     */
    public void setRepaymentPeriod(Integer repaymentPeriod) {
        this.repaymentPeriod = repaymentPeriod;
    }

    /**
     * 获取当前分期期数
     *
     * @return installment_num - 当前分期期数
     */
    public Integer getInstallmentNum() {
        return installmentNum;
    }

    /**
     * 设置当前分期期数
     *
     * @param installmentNum 当前分期期数
     */
    public void setInstallmentNum(Integer installmentNum) {
        this.installmentNum = installmentNum;
    }

    /**
     * 获取应还本金
     *
     * @return repayment_amt - 应还本金
     */
    public BigDecimal getRepaymentAmt() {
        return repaymentAmt;
    }

    /**
     * 设置应还本金
     *
     * @param repaymentAmt 应还本金
     */
    public void setRepaymentAmt(BigDecimal repaymentAmt) {
        this.repaymentAmt = repaymentAmt;
    }

    /**
     * 获取应还利息
     *
     * @return repayment_fee - 应还利息
     */
    public BigDecimal getRepaymentFee() {
        return repaymentFee;
    }

    /**
     * 设置应还利息
     *
     * @param repaymentFee 应还利息
     */
    public void setRepaymentFee(BigDecimal repaymentFee) {
        this.repaymentFee = repaymentFee;
    }

    /**
     * 获取最后还款日
     *
     * @return repayment_end_date - 最后还款日
     */
    public Date getRepaymentEndDate() {
        return repaymentEndDate;
    }

    /**
     * 设置最后还款日
     *
     * @param repaymentEndDate 最后还款日
     */
    public void setRepaymentEndDate(Date repaymentEndDate) {
        this.repaymentEndDate = repaymentEndDate;
    }

    /**
     * 获取还款周期：1-周，2-月
     *
     * @return repayment_cycle - 还款周期：1-周，2-月
     */
    public Integer getRepaymentCycle() {
        return repaymentCycle;
    }

    /**
     * 设置还款周期：1-周，2-月
     *
     * @param repaymentCycle 还款周期：1-周，2-月
     */
    public void setRepaymentCycle(Integer repaymentCycle) {
        this.repaymentCycle = repaymentCycle;
    }

    /**
     * 获取还款状态：1-待还款，2-已逾期，3-已还款
     *
     * @return repayment_sts - 还款状态：1-待还款，2-已逾期，3-已还款
     */
    public Integer getRepaymentSts() {
        return repaymentSts;
    }

    /**
     * 设置还款状态：1-待还款，2-已逾期，3-已还款
     *
     * @param repaymentSts 还款状态：1-待还款，2-已逾期，3-已还款
     */
    public void setRepaymentSts(Integer repaymentSts) {
        this.repaymentSts = repaymentSts;
    }

    /**
     * 获取是否续期：0-否，1-是
     *
     * @return is_renewal - 是否续期：0-否，1-是
     */
    public Integer getIsRenewal() {
        return isRenewal;
    }

    /**
     * 设置是否续期：0-否，1-是
     *
     * @param isRenewal 是否续期：0-否，1-是
     */
    public void setIsRenewal(Integer isRenewal) {
        this.isRenewal = isRenewal;
    }

    /**
     * 获取是否逾期：0-否，1-是
     *
     * @return is_overdue - 是否逾期：0-否，1-是
     */
    public Integer getIsOverdue() {
        return isOverdue;
    }

    /**
     * 设置是否逾期：0-否，1-是
     *
     * @param isOverdue 是否逾期：0-否，1-是
     */
    public void setIsOverdue(Integer isOverdue) {
        this.isOverdue = isOverdue;
    }

    /**
     * 获取已还款金额
     *
     * @return repaymented_amt - 已还款金额
     */
    public BigDecimal getRepaymentedAmt() {
        return repaymentedAmt;
    }

    /**
     * 设置已还款金额
     *
     * @param repaymentedAmt 已还款金额
     */
    public void setRepaymentedAmt(BigDecimal repaymentedAmt) {
        this.repaymentedAmt = repaymentedAmt;
    }

    /**
     * 获取减免金额
     *
     * @return waiver_amount - 减免金额
     */
    public BigDecimal getWaiverAmount() {
        return waiverAmount;
    }

    /**
     * 设置减免金额
     *
     * @param waiverAmount 减免金额
     */
    public void setWaiverAmount(BigDecimal waiverAmount) {
        this.waiverAmount = waiverAmount;
    }

    /**
     * 获取逾期天数
     *
     * @return overdue_day - 逾期天数
     */
    public Integer getOverdueDay() {
        return overdueDay;
    }

    /**
     * 设置逾期天数
     *
     * @param overdueDay 逾期天数
     */
    public void setOverdueDay(Integer overdueDay) {
        this.overdueDay = overdueDay;
    }

    /**
     * 获取逾期费率（%）
     *
     * @return overdue_rate - 逾期费率（%）
     */
    public BigDecimal getOverdueRate() {
        return overdueRate;
    }

    /**
     * 设置逾期费率（%）
     *
     * @param overdueRate 逾期费率（%）
     */
    public void setOverdueRate(BigDecimal overdueRate) {
        this.overdueRate = overdueRate;
    }

    /**
     * 获取定额逾期费（元/天）
     *
     * @return overdue_fee - 定额逾期费（元/天）
     */
    public BigDecimal getOverdueFee() {
        return overdueFee;
    }

    /**
     * 设置定额逾期费（元/天）
     *
     * @param overdueFee 定额逾期费（元/天）
     */
    public void setOverdueFee(BigDecimal overdueFee) {
        this.overdueFee = overdueFee;
    }

    /**
     * 获取逾期金额
     *
     * @return overdue_amt - 逾期金额
     */
    public BigDecimal getOverdueAmt() {
        return overdueAmt;
    }

    /**
     * 设置逾期金额
     *
     * @param overdueAmt 逾期金额
     */
    public void setOverdueAmt(BigDecimal overdueAmt) {
        this.overdueAmt = overdueAmt;
    }

    /**
     * 获取还款完成时间
     *
     * @return repaymented_time - 还款完成时间
     */
    public Date getRepaymentedTime() {
        return repaymentedTime;
    }

    /**
     * 设置还款完成时间
     *
     * @param repaymentedTime 还款完成时间
     */
    public void setRepaymentedTime(Date repaymentedTime) {
        this.repaymentedTime = repaymentedTime;
    }

    /**
     * 获取还款渠道
     *
     * @return repayment_channel - 还款渠道
     */
    public String getRepaymentChannel() {
        return repaymentChannel;
    }

    /**
     * 设置还款渠道
     *
     * @param repaymentChannel 还款渠道
     */
    public void setRepaymentChannel(String repaymentChannel) {
        this.repaymentChannel = repaymentChannel;
    }

    /**
     * 获取还款银行卡号
     *
     * @return bank_card_no - 还款银行卡号
     */
    public String getBankCardNo() {
        return bankCardNo;
    }

    /**
     * 设置还款银行卡号
     *
     * @param bankCardNo 还款银行卡号
     */
    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    /**
     * 获取还款银行编码
     *
     * @return bank_code - 还款银行编码
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * 设置还款银行编码
     *
     * @param bankCode 还款银行编码
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    /**
     * 获取还款银行名称
     *
     * @return bank_name - 还款银行名称
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置还款银行名称
     *
     * @param bankName 还款银行名称
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
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
     * 获取更新操作员
     *
     * @return update_manage_name - 更新操作员
     */
    public String getUpdateManageName() {
        return updateManageName;
    }

    /**
     * 设置更新操作员
     *
     * @param updateManageName 更新操作员
     */
    public void setUpdateManageName(String updateManageName) {
        this.updateManageName = updateManageName;
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
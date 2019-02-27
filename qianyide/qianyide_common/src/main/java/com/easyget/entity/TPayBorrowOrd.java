package com.easyget.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_pay_borrow_ord")
public class TPayBorrowOrd {
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
     * 是否老用户借款：0-否，1-是
     */
    @Column(name = "is_old_loan")
    private Integer isOldLoan;

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
     * 申请时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 借款金额（单位：元）
     */
    @Column(name = "borrow_amt")
    private BigDecimal borrowAmt;

    /**
     * 认证费（单位：元）
     */
    @Column(name = "auth_fee")
    private BigDecimal authFee;

    /**
     * 服务费（单位：元）
     */
    @Column(name = "serve_fee")
    private BigDecimal serveFee;

    /**
     * 利息（单位：元）
     */
    @Column(name = "interest_fee")
    private BigDecimal interestFee;

    /**
     * 还款期数
     */
    @Column(name = "repayment_period")
    private Integer repaymentPeriod;

    /**
     * 还款周期：1-周，2-月
     */
    @Column(name = "repayment_cycle")
    private Integer repaymentCycle;

    /**
     * 分期费率（单位%/期）
     */
    @Column(name = "installment_rate")
    private BigDecimal installmentRate;

    /**
     * 定额分期费（单位：元/期）
     */
    @Column(name = "installment_fee")
    private BigDecimal installmentFee;

    /**
     * 逾期费率（单位%）
     */
    @Column(name = "overdue_rate")
    private BigDecimal overdueRate;

    /**
     * 定额逾期费（单位：元/天）
     */
    @Column(name = "overdue_fee")
    private BigDecimal overdueFee;

    /**
     * 订单状态：1-已提交，2-风控审核中，3-风控审核通过，4-风控审核拒绝，5-人工审核通过，6-人工审核拒绝，7-放款中，8-放款成功，9-放款失败，10-已结清
     */
    @Column(name = "order_sts")
    private Integer orderSts;

    /**
     * 机器审核时间
     */
    @Column(name = "machine_audit_time")
    private Date machineAuditTime;

    /**
     * 人工审核时间
     */
    @Column(name = "manual_audit_time")
    private Date manualAuditTime;

    /**
     * 审核管理员
     */
    @Column(name = "audit_manage_name")
    private String auditManageName;

    /**
     * 放款渠道
     */
    @Column(name = "loan_channel")
    private String loanChannel;

    /**
     * 放款时间
     */
    @Column(name = "loan_time")
    private Date loanTime;

    /**
     * 设备类型
     */
    @Column(name = "device_type")
    private String deviceType;

    /**
     * 设备识别码
     */
    @Column(name = "device_id_code")
    private String deviceIdCode;

    /**
     * 设备型号
     */
    @Column(name = "device_model")
    private String deviceModel;

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
     * 更新管理员
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
     * 获取是否老用户借款：0-否，1-是
     *
     * @return is_old_loan - 是否老用户借款：0-否，1-是
     */
    public Integer getIsOldLoan() {
        return isOldLoan;
    }

    /**
     * 设置是否老用户借款：0-否，1-是
     *
     * @param isOldLoan 是否老用户借款：0-否，1-是
     */
    public void setIsOldLoan(Integer isOldLoan) {
        this.isOldLoan = isOldLoan;
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
     * 获取申请时间
     *
     * @return create_time - 申请时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置申请时间
     *
     * @param createTime 申请时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取借款金额（单位：元）
     *
     * @return borrow_amt - 借款金额（单位：元）
     */
    public BigDecimal getBorrowAmt() {
        return borrowAmt;
    }

    /**
     * 设置借款金额（单位：元）
     *
     * @param borrowAmt 借款金额（单位：元）
     */
    public void setBorrowAmt(BigDecimal borrowAmt) {
        this.borrowAmt = borrowAmt;
    }

    /**
     * 获取认证费（单位：元）
     *
     * @return auth_fee - 认证费（单位：元）
     */
    public BigDecimal getAuthFee() {
        return authFee;
    }

    /**
     * 设置认证费（单位：元）
     *
     * @param authFee 认证费（单位：元）
     */
    public void setAuthFee(BigDecimal authFee) {
        this.authFee = authFee;
    }

    /**
     * 获取服务费（单位：元）
     *
     * @return serve_fee - 服务费（单位：元）
     */
    public BigDecimal getServeFee() {
        return serveFee;
    }

    /**
     * 设置服务费（单位：元）
     *
     * @param serveFee 服务费（单位：元）
     */
    public void setServeFee(BigDecimal serveFee) {
        this.serveFee = serveFee;
    }

    /**
     * 获取利息（单位：元）
     *
     * @return interest_fee - 利息（单位：元）
     */
    public BigDecimal getInterestFee() {
        return interestFee;
    }

    /**
     * 设置利息（单位：元）
     *
     * @param interestFee 利息（单位：元）
     */
    public void setInterestFee(BigDecimal interestFee) {
        this.interestFee = interestFee;
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
     * 获取分期费率（单位%/期）
     *
     * @return installment_rate - 分期费率（单位%/期）
     */
    public BigDecimal getInstallmentRate() {
        return installmentRate;
    }

    /**
     * 设置分期费率（单位%/期）
     *
     * @param installmentRate 分期费率（单位%/期）
     */
    public void setInstallmentRate(BigDecimal installmentRate) {
        this.installmentRate = installmentRate;
    }

    /**
     * 获取定额分期费（单位：元/期）
     *
     * @return installment_fee - 定额分期费（单位：元/期）
     */
    public BigDecimal getInstallmentFee() {
        return installmentFee;
    }

    /**
     * 设置定额分期费（单位：元/期）
     *
     * @param installmentFee 定额分期费（单位：元/期）
     */
    public void setInstallmentFee(BigDecimal installmentFee) {
        this.installmentFee = installmentFee;
    }

    /**
     * 获取逾期费率（单位%）
     *
     * @return overdue_rate - 逾期费率（单位%）
     */
    public BigDecimal getOverdueRate() {
        return overdueRate;
    }

    /**
     * 设置逾期费率（单位%）
     *
     * @param overdueRate 逾期费率（单位%）
     */
    public void setOverdueRate(BigDecimal overdueRate) {
        this.overdueRate = overdueRate;
    }

    /**
     * 获取定额逾期费（单位：元/天）
     *
     * @return overdue_fee - 定额逾期费（单位：元/天）
     */
    public BigDecimal getOverdueFee() {
        return overdueFee;
    }

    /**
     * 设置定额逾期费（单位：元/天）
     *
     * @param overdueFee 定额逾期费（单位：元/天）
     */
    public void setOverdueFee(BigDecimal overdueFee) {
        this.overdueFee = overdueFee;
    }

    /**
     * 获取订单状态：1-已提交，2-风控审核中，3-风控审核通过，4-风控审核拒绝，5-人工审核通过，6-人工审核拒绝，7-放款中，8-放款成功，9-放款失败，10-已结清
     *
     * @return order_sts - 订单状态：1-已提交，2-风控审核中，3-风控审核通过，4-风控审核拒绝，5-人工审核通过，6-人工审核拒绝，7-放款中，8-放款成功，9-放款失败，10-已结清
     */
    public Integer getOrderSts() {
        return orderSts;
    }

    /**
     * 设置订单状态：1-已提交，2-风控审核中，3-风控审核通过，4-风控审核拒绝，5-人工审核通过，6-人工审核拒绝，7-放款中，8-放款成功，9-放款失败，10-已结清
     *
     * @param orderSts 订单状态：1-已提交，2-风控审核中，3-风控审核通过，4-风控审核拒绝，5-人工审核通过，6-人工审核拒绝，7-放款中，8-放款成功，9-放款失败，10-已结清
     */
    public void setOrderSts(Integer orderSts) {
        this.orderSts = orderSts;
    }

    /**
     * 获取机器审核时间
     *
     * @return machine_audit_time - 机器审核时间
     */
    public Date getMachineAuditTime() {
        return machineAuditTime;
    }

    /**
     * 设置机器审核时间
     *
     * @param machineAuditTime 机器审核时间
     */
    public void setMachineAuditTime(Date machineAuditTime) {
        this.machineAuditTime = machineAuditTime;
    }

    /**
     * 获取人工审核时间
     *
     * @return manual_audit_time - 人工审核时间
     */
    public Date getManualAuditTime() {
        return manualAuditTime;
    }

    /**
     * 设置人工审核时间
     *
     * @param manualAuditTime 人工审核时间
     */
    public void setManualAuditTime(Date manualAuditTime) {
        this.manualAuditTime = manualAuditTime;
    }

    /**
     * 获取审核管理员
     *
     * @return audit_manage_name - 审核管理员
     */
    public String getAuditManageName() {
        return auditManageName;
    }

    /**
     * 设置审核管理员
     *
     * @param auditManageName 审核管理员
     */
    public void setAuditManageName(String auditManageName) {
        this.auditManageName = auditManageName;
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
     * 获取设备类型
     *
     * @return device_type - 设备类型
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * 设置设备类型
     *
     * @param deviceType 设备类型
     */
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * 获取设备识别码
     *
     * @return device_id_code - 设备识别码
     */
    public String getDeviceIdCode() {
        return deviceIdCode;
    }

    /**
     * 设置设备识别码
     *
     * @param deviceIdCode 设备识别码
     */
    public void setDeviceIdCode(String deviceIdCode) {
        this.deviceIdCode = deviceIdCode;
    }

    /**
     * 获取设备型号
     *
     * @return device_model - 设备型号
     */
    public String getDeviceModel() {
        return deviceModel;
    }

    /**
     * 设置设备型号
     *
     * @param deviceModel 设备型号
     */
    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
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
     * 获取更新管理员
     *
     * @return update_manage_name - 更新管理员
     */
    public String getUpdateManageName() {
        return updateManageName;
    }

    /**
     * 设置更新管理员
     *
     * @param updateManageName 更新管理员
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
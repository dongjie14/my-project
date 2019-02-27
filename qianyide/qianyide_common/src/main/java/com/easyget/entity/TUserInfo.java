package com.easyget.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user_info")
public class TUserInfo {
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
     * 用户姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 手机号
     */
    @Column(name = "user_phone")
    private String userPhone;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 名族
     */
    private String race;

    /**
     * 身份证号
     */
    @Column(name = "user_id_no")
    private String userIdNo;

    /**
     * 登录密码
     */
    @Column(name = "login_password")
    private String loginPassword;

    /**
     * 支付密码
     */
    @Column(name = "pay_password")
    private String payPassword;

    /**
     * 所在省
     */
    private Integer province;

    /**
     * 所在市
     */
    private Integer city;

    /**
     * 所在区县
     */
    private Integer area;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 居住时长
     */
    @Column(name = "live_time")
    private Integer liveTime;

    /**
     * 房屋类型
     */
    @Column(name = "house_type")
    private Integer houseType;

    /**
     * 行业类别
     */
    private Integer industry;

    /**
     * 职位
     */
    private Integer position;

    /**
     * 收入
     */
    private BigDecimal income;

    /**
     * 单位名称
     */
    @Column(name = "work_unit_name")
    private String workUnitName;

    /**
     * 单位地址
     */
    @Column(name = "work_unit_addr")
    private String workUnitAddr;

    /**
     * 单位电话
     */
    @Column(name = "work_unit_tel")
    private String workUnitTel;

    /**
     * 婚姻状态
     */
    @Column(name = "marriage_sts")
    private Integer marriageSts;

    /**
     * 学历
     */
    private Integer education;

    /**
     * 注册时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 用户状态：1-正常，2-注销，3-灰名单，4-黑名单
     */
    @Column(name = "user_sts")
    private Integer userSts;

    /**
     * 是否老用户：0-否，1-是
     */
    @Column(name = "is_old")
    private Integer isOld;

    /**
     * 邀请码
     */
    @Column(name = "share_code")
    private String shareCode;

    /**
     * 邀请返利率
     */
    @Column(name = "invite_rate")
    private BigDecimal inviteRate;

    /**
     * 邀请人编号
     */
    @Column(name = "invite_user_no")
    private String inviteUserNo;

    /**
     * 是否提交身份信息：0-否，1-是
     */
    @Column(name = "is_identity_info")
    private Integer isIdentityInfo;

    /**
     * 是否已实名认证：0-否，1-是，2-认证中
     */
    @Column(name = "is_real_name")
    private Integer isRealName;

    /**
     * 是否已绑卡：0-否，1-是
     */
    @Column(name = "is_bind_card")
    private Integer isBindCard;

    /**
     * 是否提交紧急联系人：0-否，1-是
     */
    @Column(name = "is_linkman")
    private Integer isLinkman;

    /**
     * 是否运营商认证：0-否，1-是，2-认证中
     */
    @Column(name = "is_operator")
    private Integer isOperator;

    /**
     * 是否提交电商认证：0-否，1-是，2-认证中
     */
    @Column(name = "is_ec_auth")
    private Integer isEcAuth;

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
     * 获取手机号
     *
     * @return user_phone - 手机号
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 设置手机号
     *
     * @param userPhone 手机号
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取名族
     *
     * @return race - 名族
     */
    public String getRace() {
        return race;
    }

    /**
     * 设置名族
     *
     * @param race 名族
     */
    public void setRace(String race) {
        this.race = race;
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
     * 获取登录密码
     *
     * @return login_password - 登录密码
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * 设置登录密码
     *
     * @param loginPassword 登录密码
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    /**
     * 获取支付密码
     *
     * @return pay_password - 支付密码
     */
    public String getPayPassword() {
        return payPassword;
    }

    /**
     * 设置支付密码
     *
     * @param payPassword 支付密码
     */
    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    /**
     * 获取所在省
     *
     * @return province - 所在省
     */
    public Integer getProvince() {
        return province;
    }

    /**
     * 设置所在省
     *
     * @param province 所在省
     */
    public void setProvince(Integer province) {
        this.province = province;
    }

    /**
     * 获取所在市
     *
     * @return city - 所在市
     */
    public Integer getCity() {
        return city;
    }

    /**
     * 设置所在市
     *
     * @param city 所在市
     */
    public void setCity(Integer city) {
        this.city = city;
    }

    /**
     * 获取所在区县
     *
     * @return area - 所在区县
     */
    public Integer getArea() {
        return area;
    }

    /**
     * 设置所在区县
     *
     * @param area 所在区县
     */
    public void setArea(Integer area) {
        this.area = area;
    }

    /**
     * 获取详细地址
     *
     * @return address - 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置详细地址
     *
     * @param address 详细地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取居住时长
     *
     * @return live_time - 居住时长
     */
    public Integer getLiveTime() {
        return liveTime;
    }

    /**
     * 设置居住时长
     *
     * @param liveTime 居住时长
     */
    public void setLiveTime(Integer liveTime) {
        this.liveTime = liveTime;
    }

    /**
     * 获取房屋类型
     *
     * @return house_type - 房屋类型
     */
    public Integer getHouseType() {
        return houseType;
    }

    /**
     * 设置房屋类型
     *
     * @param houseType 房屋类型
     */
    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }

    /**
     * 获取行业类别
     *
     * @return industry - 行业类别
     */
    public Integer getIndustry() {
        return industry;
    }

    /**
     * 设置行业类别
     *
     * @param industry 行业类别
     */
    public void setIndustry(Integer industry) {
        this.industry = industry;
    }

    /**
     * 获取职位
     *
     * @return position - 职位
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * 设置职位
     *
     * @param position 职位
     */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * 获取收入
     *
     * @return income - 收入
     */
    public BigDecimal getIncome() {
        return income;
    }

    /**
     * 设置收入
     *
     * @param income 收入
     */
    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    /**
     * 获取单位名称
     *
     * @return work_unit_name - 单位名称
     */
    public String getWorkUnitName() {
        return workUnitName;
    }

    /**
     * 设置单位名称
     *
     * @param workUnitName 单位名称
     */
    public void setWorkUnitName(String workUnitName) {
        this.workUnitName = workUnitName;
    }

    /**
     * 获取单位地址
     *
     * @return work_unit_addr - 单位地址
     */
    public String getWorkUnitAddr() {
        return workUnitAddr;
    }

    /**
     * 设置单位地址
     *
     * @param workUnitAddr 单位地址
     */
    public void setWorkUnitAddr(String workUnitAddr) {
        this.workUnitAddr = workUnitAddr;
    }

    /**
     * 获取单位电话
     *
     * @return work_unit_tel - 单位电话
     */
    public String getWorkUnitTel() {
        return workUnitTel;
    }

    /**
     * 设置单位电话
     *
     * @param workUnitTel 单位电话
     */
    public void setWorkUnitTel(String workUnitTel) {
        this.workUnitTel = workUnitTel;
    }

    /**
     * 获取婚姻状态
     *
     * @return marriage_sts - 婚姻状态
     */
    public Integer getMarriageSts() {
        return marriageSts;
    }

    /**
     * 设置婚姻状态
     *
     * @param marriageSts 婚姻状态
     */
    public void setMarriageSts(Integer marriageSts) {
        this.marriageSts = marriageSts;
    }

    /**
     * 获取学历
     *
     * @return education - 学历
     */
    public Integer getEducation() {
        return education;
    }

    /**
     * 设置学历
     *
     * @param education 学历
     */
    public void setEducation(Integer education) {
        this.education = education;
    }

    /**
     * 获取注册时间
     *
     * @return create_time - 注册时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置注册时间
     *
     * @param createTime 注册时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取用户状态：1-正常，2-注销，3-灰名单，4-黑名单
     *
     * @return user_sts - 用户状态：1-正常，2-注销，3-灰名单，4-黑名单
     */
    public Integer getUserSts() {
        return userSts;
    }

    /**
     * 设置用户状态：1-正常，2-注销，3-灰名单，4-黑名单
     *
     * @param userSts 用户状态：1-正常，2-注销，3-灰名单，4-黑名单
     */
    public void setUserSts(Integer userSts) {
        this.userSts = userSts;
    }

    /**
     * 获取是否老用户：0-否，1-是
     *
     * @return is_old - 是否老用户：0-否，1-是
     */
    public Integer getIsOld() {
        return isOld;
    }

    /**
     * 设置是否老用户：0-否，1-是
     *
     * @param isOld 是否老用户：0-否，1-是
     */
    public void setIsOld(Integer isOld) {
        this.isOld = isOld;
    }

    /**
     * 获取邀请码
     *
     * @return share_code - 邀请码
     */
    public String getShareCode() {
        return shareCode;
    }

    /**
     * 设置邀请码
     *
     * @param shareCode 邀请码
     */
    public void setShareCode(String shareCode) {
        this.shareCode = shareCode;
    }

    /**
     * 获取邀请返利率
     *
     * @return invite_rate - 邀请返利率
     */
    public BigDecimal getInviteRate() {
        return inviteRate;
    }

    /**
     * 设置邀请返利率
     *
     * @param inviteRate 邀请返利率
     */
    public void setInviteRate(BigDecimal inviteRate) {
        this.inviteRate = inviteRate;
    }

    /**
     * 获取邀请人编号
     *
     * @return invite_user_no - 邀请人编号
     */
    public String getInviteUserNo() {
        return inviteUserNo;
    }

    /**
     * 设置邀请人编号
     *
     * @param inviteUserNo 邀请人编号
     */
    public void setInviteUserNo(String inviteUserNo) {
        this.inviteUserNo = inviteUserNo;
    }

    /**
     * 获取是否提交身份信息：0-否，1-是
     *
     * @return is_identity_info - 是否提交身份信息：0-否，1-是
     */
    public Integer getIsIdentityInfo() {
        return isIdentityInfo;
    }

    /**
     * 设置是否提交身份信息：0-否，1-是
     *
     * @param isIdentityInfo 是否提交身份信息：0-否，1-是
     */
    public void setIsIdentityInfo(Integer isIdentityInfo) {
        this.isIdentityInfo = isIdentityInfo;
    }

    /**
     * 获取是否已实名认证：0-否，1-是，2-认证中
     *
     * @return is_real_name - 是否已实名认证：0-否，1-是，2-认证中
     */
    public Integer getIsRealName() {
        return isRealName;
    }

    /**
     * 设置是否已实名认证：0-否，1-是，2-认证中
     *
     * @param isRealName 是否已实名认证：0-否，1-是，2-认证中
     */
    public void setIsRealName(Integer isRealName) {
        this.isRealName = isRealName;
    }

    /**
     * 获取是否已绑卡：0-否，1-是
     *
     * @return is_bind_card - 是否已绑卡：0-否，1-是
     */
    public Integer getIsBindCard() {
        return isBindCard;
    }

    /**
     * 设置是否已绑卡：0-否，1-是
     *
     * @param isBindCard 是否已绑卡：0-否，1-是
     */
    public void setIsBindCard(Integer isBindCard) {
        this.isBindCard = isBindCard;
    }

    /**
     * 获取是否提交紧急联系人：0-否，1-是
     *
     * @return is_linkman - 是否提交紧急联系人：0-否，1-是
     */
    public Integer getIsLinkman() {
        return isLinkman;
    }

    /**
     * 设置是否提交紧急联系人：0-否，1-是
     *
     * @param isLinkman 是否提交紧急联系人：0-否，1-是
     */
    public void setIsLinkman(Integer isLinkman) {
        this.isLinkman = isLinkman;
    }

    /**
     * 获取是否运营商认证：0-否，1-是，2-认证中
     *
     * @return is_operator - 是否运营商认证：0-否，1-是，2-认证中
     */
    public Integer getIsOperator() {
        return isOperator;
    }

    /**
     * 设置是否运营商认证：0-否，1-是，2-认证中
     *
     * @param isOperator 是否运营商认证：0-否，1-是，2-认证中
     */
    public void setIsOperator(Integer isOperator) {
        this.isOperator = isOperator;
    }

    /**
     * 获取是否提交电商认证：0-否，1-是，2-认证中
     *
     * @return is_ec_auth - 是否提交电商认证：0-否，1-是，2-认证中
     */
    public Integer getIsEcAuth() {
        return isEcAuth;
    }

    /**
     * 设置是否提交电商认证：0-否，1-是，2-认证中
     *
     * @param isEcAuth 是否提交电商认证：0-否，1-是，2-认证中
     */
    public void setIsEcAuth(Integer isEcAuth) {
        this.isEcAuth = isEcAuth;
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
package com.easyget.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sys_user")
public class TSysUser {
    /**
     * 主键ID
     */
    @Id
    private Integer id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 角色ID
     */
    @Column(name = "role_id")
    private String roleId;

    /**
     * 账号
     */
    @Column(name = "user_account")
    private String userAccount;

    /**
     * 密码
     */
    @Column(name = "user_passwd")
    private String userPasswd;

    /**
     * 状态：0-无效，1-有效
     */
    @Column(name = "user_sts")
    private Integer userSts;

    /**
     * 用户类型：1-管理员，2-普通用户
     */
    @Column(name = "user_type")
    private Integer userType;

    /**
     * 姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 手机号
     */
    @Column(name = "user_phone")
    private String userPhone;

    /**
     * 邮箱
     */
    @Column(name = "user_email")
    private String userEmail;

    /**
     * 备注
     */
    private String remark;

    /**
     * 最后登录时间
     */
    @Column(name = "login_time")
    private Date loginTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取角色ID
     *
     * @return role_id - 角色ID
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 设置角色ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取账号
     *
     * @return user_account - 账号
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * 设置账号
     *
     * @param userAccount 账号
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    /**
     * 获取密码
     *
     * @return user_passwd - 密码
     */
    public String getUserPasswd() {
        return userPasswd;
    }

    /**
     * 设置密码
     *
     * @param userPasswd 密码
     */
    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    /**
     * 获取状态：0-无效，1-有效
     *
     * @return user_sts - 状态：0-无效，1-有效
     */
    public Integer getUserSts() {
        return userSts;
    }

    /**
     * 设置状态：0-无效，1-有效
     *
     * @param userSts 状态：0-无效，1-有效
     */
    public void setUserSts(Integer userSts) {
        this.userSts = userSts;
    }

    /**
     * 获取用户类型：1-管理员，2-普通用户
     *
     * @return user_type - 用户类型：1-管理员，2-普通用户
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 设置用户类型：1-管理员，2-普通用户
     *
     * @param userType 用户类型：1-管理员，2-普通用户
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 获取姓名
     *
     * @return user_name - 姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置姓名
     *
     * @param userName 姓名
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
     * 获取邮箱
     *
     * @return user_email - 邮箱
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * 设置邮箱
     *
     * @param userEmail 邮箱
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取最后登录时间
     *
     * @return login_time - 最后登录时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 设置最后登录时间
     *
     * @param loginTime 最后登录时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
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
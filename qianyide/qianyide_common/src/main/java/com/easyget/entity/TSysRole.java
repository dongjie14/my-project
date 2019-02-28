package com.easyget.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "t_sys_role")
public class TSysRole {

    public static final String SUPER = "0";

    /**
     * 主键ID
     */
    @Id
    private Integer id;

    /**
     * 角色ID
     */
    @Column(name = "role_id")
    private String roleId;

    /**
     * 上级角色ID
     */
    @Column(name = "super_role_id")
    private String superRoleId;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 是否生效：0-无效，1-有效
     */
    private Integer enable;

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
     * 更新人
     */
    @Column(name = "update_account")
    private String updateAccount;

    /**
     * 时间戳
     */
    @Column(name = "tm_smp")
    private Date tmSmp;

    @Transient
    private String roleNo;
    @Transient
    private List<TSysRole> children;
    @Transient
    private String roleModules;

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
     * 获取上级角色ID
     *
     * @return super_role_id - 上级角色ID
     */
    public String getSuperRoleId() {
        return superRoleId;
    }

    /**
     * 设置上级角色ID
     *
     * @param superRoleId 上级角色ID
     */
    public void setSuperRoleId(String superRoleId) {
        this.superRoleId = superRoleId;
    }

    /**
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取是否生效：0-无效，1-有效
     *
     * @return enable - 是否生效：0-无效，1-有效
     */
    public Integer getEnable() {
        return enable;
    }

    /**
     * 设置是否生效：0-无效，1-有效
     *
     * @param enable 是否生效：0-无效，1-有效
     */
    public void setEnable(Integer enable) {
        this.enable = enable;
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
     * 获取更新人
     *
     * @return update_account - 更新人
     */
    public String getUpdateAccount() {
        return updateAccount;
    }

    /**
     * 设置更新人
     *
     * @param updateAccount 更新人
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

    public String getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo;
    }

    public List<TSysRole> getChildren() {
        return children;
    }

    public void setChildren(List<TSysRole> children) {
        this.children = children;
    }

    public String getRoleModules() {
        return roleModules;
    }

    public void setRoleModules(String roleModules) {
        this.roleModules = roleModules;
    }
}
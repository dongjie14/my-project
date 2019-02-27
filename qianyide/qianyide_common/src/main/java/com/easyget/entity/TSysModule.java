package com.easyget.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sys_module")
public class TSysModule {
    /**
     * 主键ID
     */
    @Id
    private Integer id;

    /**
     * 模块ID
     */
    @Column(name = "module_id")
    private String moduleId;

    /**
     * 上级模块ID
     */
    @Column(name = "super_module_id")
    private String superModuleId;

    /**
     * 模块URL
     */
    @Column(name = "module_url")
    private String moduleUrl;

    /**
     * 模块类型：1-菜单，2-页面，3-按钮
     */
    @Column(name = "module_type")
    private Integer moduleType;

    /**
     * 模块排序
     */
    @Column(name = "module_rank")
    private Integer moduleRank;

    /**
     * 是否生效：0-无效，1-有效
     */
    private Integer enable;

    /**
     * 备注
     */
    private String remark;

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
     * 获取模块ID
     *
     * @return module_id - 模块ID
     */
    public String getModuleId() {
        return moduleId;
    }

    /**
     * 设置模块ID
     *
     * @param moduleId 模块ID
     */
    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * 获取上级模块ID
     *
     * @return super_module_id - 上级模块ID
     */
    public String getSuperModuleId() {
        return superModuleId;
    }

    /**
     * 设置上级模块ID
     *
     * @param superModuleId 上级模块ID
     */
    public void setSuperModuleId(String superModuleId) {
        this.superModuleId = superModuleId;
    }

    /**
     * 获取模块URL
     *
     * @return module_url - 模块URL
     */
    public String getModuleUrl() {
        return moduleUrl;
    }

    /**
     * 设置模块URL
     *
     * @param moduleUrl 模块URL
     */
    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl;
    }

    /**
     * 获取模块类型：1-菜单，2-页面，3-按钮
     *
     * @return module_type - 模块类型：1-菜单，2-页面，3-按钮
     */
    public Integer getModuleType() {
        return moduleType;
    }

    /**
     * 设置模块类型：1-菜单，2-页面，3-按钮
     *
     * @param moduleType 模块类型：1-菜单，2-页面，3-按钮
     */
    public void setModuleType(Integer moduleType) {
        this.moduleType = moduleType;
    }

    /**
     * 获取模块排序
     *
     * @return module_rank - 模块排序
     */
    public Integer getModuleRank() {
        return moduleRank;
    }

    /**
     * 设置模块排序
     *
     * @param moduleRank 模块排序
     */
    public void setModuleRank(Integer moduleRank) {
        this.moduleRank = moduleRank;
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
}
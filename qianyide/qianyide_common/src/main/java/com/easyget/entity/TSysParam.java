package com.easyget.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sys_param")
public class TSysParam {
    /**
     * 主键ID
     */
    @Id
    private Integer id;

    /**
     * 参数类型
     */
    @Column(name = "param_type")
    private String paramType;

    /**
     * 参数键
     */
    @Column(name = "param_key")
    private String paramKey;

    /**
     * 参数名称
     */
    @Column(name = "param_name")
    private String paramName;

    /**
     * 参数值
     */
    @Column(name = "param_val")
    private String paramVal;

    /**
     * 备注
     */
    private String remark;

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
     * 获取参数类型
     *
     * @return param_type - 参数类型
     */
    public String getParamType() {
        return paramType;
    }

    /**
     * 设置参数类型
     *
     * @param paramType 参数类型
     */
    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    /**
     * 获取参数键
     *
     * @return param_key - 参数键
     */
    public String getParamKey() {
        return paramKey;
    }

    /**
     * 设置参数键
     *
     * @param paramKey 参数键
     */
    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }

    /**
     * 获取参数名称
     *
     * @return param_name - 参数名称
     */
    public String getParamName() {
        return paramName;
    }

    /**
     * 设置参数名称
     *
     * @param paramName 参数名称
     */
    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    /**
     * 获取参数值
     *
     * @return param_val - 参数值
     */
    public String getParamVal() {
        return paramVal;
    }

    /**
     * 设置参数值
     *
     * @param paramVal 参数值
     */
    public void setParamVal(String paramVal) {
        this.paramVal = paramVal;
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
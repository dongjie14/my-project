package com.easyget.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sys_return_code")
public class TSysReturnCode {

    public enum defaultType{
        SUCCESS(1, "DEF00000", "成功"),
        FAIL(2, "DEF20000", "失败"),
        DOING(3, "DEF10000", "处理中"),
        UN_LOGIN(4, "DEF00001", "未登录"),
        ERROR(5, "DEF99999", "异常");

        private Integer returnType;
        private String returnCode;
        private String returnInfo;

        defaultType(Integer returnType, String returnCode, String returnInfo) {
            this.returnType = returnType;
            this.returnCode = returnCode;
            this.returnInfo = returnInfo;
        }

        public Integer getReturnType() {
            return returnType;
        }
        public void setReturnType(Integer returnType) {
            this.returnType = returnType;
        }
        public String getReturnCode() {
            return returnCode;
        }
        public void setReturnCode(String returnCode) {
            this.returnCode = returnCode;
        }
        public String getReturnInfo() {
            return returnInfo;
        }
        public void setReturnInfo(String returnInfo) {
            this.returnInfo = returnInfo;
        }
    }

    /**
     * 主键ID
     */
    @Id
    private Integer id;

    /**
     * 返回码
     */
    @Column(name = "return_code")
    private String returnCode;

    /**
     * 返回码类型：1-成功，2-失败，3-处理中，4-未登录
     */
    @Column(name = "return_type")
    private Integer returnType;

    /**
     * 返回信息
     */
    @Column(name = "return_info")
    private String returnInfo;

    /**
     * 描述
     */
    @Column(name = "desc")
    private String desc;

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
     * 获取返回码
     *
     * @return return_code - 返回码
     */
    public String getReturnCode() {
        return returnCode;
    }

    /**
     * 设置返回码
     *
     * @param returnCode 返回码
     */
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    /**
     * 获取返回码类型：1-成功，2-失败，3-处理中，4-未登录
     *
     * @return return_type - 返回码类型：1-成功，2-失败，3-处理中，4-未登录
     */
    public Integer getReturnType() {
        return returnType;
    }

    /**
     * 设置返回码类型：1-成功，2-失败，3-处理中，4-未登录
     *
     * @param returnType 返回码类型：1-成功，2-失败，3-处理中，4-未登录
     */
    public void setReturnType(Integer returnType) {
        this.returnType = returnType;
    }

    /**
     * 获取返回信息
     *
     * @return return_info - 返回信息
     */
    public String getReturnInfo() {
        return returnInfo;
    }

    /**
     * 设置返回信息
     *
     * @param returnInfo 返回信息
     */
    public void setReturnInfo(String returnInfo) {
        this.returnInfo = returnInfo;
    }

    /**
     * 获取描述
     *
     * @return desc - 描述
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置描述
     *
     * @param desc 描述
     */
    public void setDesc(String desc) {
        this.desc = desc;
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
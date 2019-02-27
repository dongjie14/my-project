package com.easyget.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user_phone_list")
public class TUserPhoneList {
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
     * 通讯录名称
     */
    @Column(name = "phone_name")
    private String phoneName;

    /**
     * 手机号码
     */
    @Column(name = "phone_no")
    private String phoneNo;

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
     * 获取通讯录名称
     *
     * @return phone_name - 通讯录名称
     */
    public String getPhoneName() {
        return phoneName;
    }

    /**
     * 设置通讯录名称
     *
     * @param phoneName 通讯录名称
     */
    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    /**
     * 获取手机号码
     *
     * @return phone_no - 手机号码
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * 设置手机号码
     *
     * @param phoneNo 手机号码
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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
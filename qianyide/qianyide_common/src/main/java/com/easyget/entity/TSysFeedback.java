package com.easyget.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sys_feedback")
public class TSysFeedback {
    /**
     * 主键ID
     */
    @Id
    private Integer id;

    /**
     * 反馈来源：1-ios，2-android
     */
    @Column(name = "feedback_source")
    private Integer feedbackSource;

    /**
     * 用户编号
     */
    @Column(name = "user_no")
    private String userNo;

    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户手机号
     */
    @Column(name = "user_phone")
    private String userPhone;

    /**
     * 反馈信息
     */
    @Column(name = "feedback_info")
    private String feedbackInfo;

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
     * 获取反馈来源：1-ios，2-android
     *
     * @return feedback_source - 反馈来源：1-ios，2-android
     */
    public Integer getFeedbackSource() {
        return feedbackSource;
    }

    /**
     * 设置反馈来源：1-ios，2-android
     *
     * @param feedbackSource 反馈来源：1-ios，2-android
     */
    public void setFeedbackSource(Integer feedbackSource) {
        this.feedbackSource = feedbackSource;
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
     * 获取用户名称
     *
     * @return user_name - 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名称
     *
     * @param userName 用户名称
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
     * 获取反馈信息
     *
     * @return feedback_info - 反馈信息
     */
    public String getFeedbackInfo() {
        return feedbackInfo;
    }

    /**
     * 设置反馈信息
     *
     * @param feedbackInfo 反馈信息
     */
    public void setFeedbackInfo(String feedbackInfo) {
        this.feedbackInfo = feedbackInfo;
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
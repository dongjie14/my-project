package com.easyget.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_message_record")
public class TMessageRecord {
    /**
     * 主键ID
     */
    @Id
    private Integer id;

    /**
     * 收信人姓名
     */
    @Column(name = "rec_name")
    private String recName;

    /**
     * 收信人手机号
     */
    @Column(name = "rec_phone")
    private String recPhone;

    /**
     * 收信人类型：1-系统管理员，2-普通管理员，3-用户
     */
    @Column(name = "rec_user_type")
    private Integer recUserType;

    /**
     * 短信标题
     */
    @Column(name = "msg_title")
    private String msgTitle;

    /**
     * 短信内容
     */
    @Column(name = "msg_content")
    private String msgContent;

    /**
     * 短信发送时间
     */
    @Column(name = "msg_send_time")
    private Date msgSendTime;

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
     * 获取收信人姓名
     *
     * @return rec_name - 收信人姓名
     */
    public String getRecName() {
        return recName;
    }

    /**
     * 设置收信人姓名
     *
     * @param recName 收信人姓名
     */
    public void setRecName(String recName) {
        this.recName = recName;
    }

    /**
     * 获取收信人手机号
     *
     * @return rec_phone - 收信人手机号
     */
    public String getRecPhone() {
        return recPhone;
    }

    /**
     * 设置收信人手机号
     *
     * @param recPhone 收信人手机号
     */
    public void setRecPhone(String recPhone) {
        this.recPhone = recPhone;
    }

    /**
     * 获取收信人类型：1-系统管理员，2-普通管理员，3-用户
     *
     * @return rec_user_type - 收信人类型：1-系统管理员，2-普通管理员，3-用户
     */
    public Integer getRecUserType() {
        return recUserType;
    }

    /**
     * 设置收信人类型：1-系统管理员，2-普通管理员，3-用户
     *
     * @param recUserType 收信人类型：1-系统管理员，2-普通管理员，3-用户
     */
    public void setRecUserType(Integer recUserType) {
        this.recUserType = recUserType;
    }

    /**
     * 获取短信标题
     *
     * @return msg_title - 短信标题
     */
    public String getMsgTitle() {
        return msgTitle;
    }

    /**
     * 设置短信标题
     *
     * @param msgTitle 短信标题
     */
    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    /**
     * 获取短信内容
     *
     * @return msg_content - 短信内容
     */
    public String getMsgContent() {
        return msgContent;
    }

    /**
     * 设置短信内容
     *
     * @param msgContent 短信内容
     */
    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    /**
     * 获取短信发送时间
     *
     * @return msg_send_time - 短信发送时间
     */
    public Date getMsgSendTime() {
        return msgSendTime;
    }

    /**
     * 设置短信发送时间
     *
     * @param msgSendTime 短信发送时间
     */
    public void setMsgSendTime(Date msgSendTime) {
        this.msgSendTime = msgSendTime;
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
package com.easyget.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_message_conf")
public class TMessageConf {
    /**
     * 主键ID
     */
    @Id
    private Integer id;

    /**
     * 模板编号
     */
    @Column(name = "msg_no")
    private String msgNo;

    /**
     * 短信主题
     */
    @Column(name = "msg_title")
    private String msgTitle;

    /**
     * 短信模板
     */
    @Column(name = "msg_template")
    private String msgTemplate;

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
     * 获取模板编号
     *
     * @return msg_no - 模板编号
     */
    public String getMsgNo() {
        return msgNo;
    }

    /**
     * 设置模板编号
     *
     * @param msgNo 模板编号
     */
    public void setMsgNo(String msgNo) {
        this.msgNo = msgNo;
    }

    /**
     * 获取短信主题
     *
     * @return msg_title - 短信主题
     */
    public String getMsgTitle() {
        return msgTitle;
    }

    /**
     * 设置短信主题
     *
     * @param msgTitle 短信主题
     */
    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    /**
     * 获取短信模板
     *
     * @return msg_template - 短信模板
     */
    public String getMsgTemplate() {
        return msgTemplate;
    }

    /**
     * 设置短信模板
     *
     * @param msgTemplate 短信模板
     */
    public void setMsgTemplate(String msgTemplate) {
        this.msgTemplate = msgTemplate;
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
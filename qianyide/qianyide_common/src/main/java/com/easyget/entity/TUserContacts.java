package com.easyget.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user_contacts")
public class TUserContacts {
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
     * 联系人类型：1-第一联系人，2-第二联系人
     */
    @Column(name = "contacts_type")
    private Integer contactsType;

    /**
     * 联系人关系
     */
    @Column(name = "contacts_relation")
    private Integer contactsRelation;

    /**
     * 联系人姓名
     */
    @Column(name = "contacts_name")
    private String contactsName;

    /**
     * 联系人手机号
     */
    @Column(name = "contacts_phone")
    private String contactsPhone;

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
     * 获取联系人类型：1-第一联系人，2-第二联系人
     *
     * @return contacts_type - 联系人类型：1-第一联系人，2-第二联系人
     */
    public Integer getContactsType() {
        return contactsType;
    }

    /**
     * 设置联系人类型：1-第一联系人，2-第二联系人
     *
     * @param contactsType 联系人类型：1-第一联系人，2-第二联系人
     */
    public void setContactsType(Integer contactsType) {
        this.contactsType = contactsType;
    }

    /**
     * 获取联系人关系
     *
     * @return contacts_relation - 联系人关系
     */
    public Integer getContactsRelation() {
        return contactsRelation;
    }

    /**
     * 设置联系人关系
     *
     * @param contactsRelation 联系人关系
     */
    public void setContactsRelation(Integer contactsRelation) {
        this.contactsRelation = contactsRelation;
    }

    /**
     * 获取联系人姓名
     *
     * @return contacts_name - 联系人姓名
     */
    public String getContactsName() {
        return contactsName;
    }

    /**
     * 设置联系人姓名
     *
     * @param contactsName 联系人姓名
     */
    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    /**
     * 获取联系人手机号
     *
     * @return contacts_phone - 联系人手机号
     */
    public String getContactsPhone() {
        return contactsPhone;
    }

    /**
     * 设置联系人手机号
     *
     * @param contactsPhone 联系人手机号
     */
    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone;
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
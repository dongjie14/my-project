package com.easyget.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user_realname")
public class TUserRealname {
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
     * 人脸图片地址
     */
    @Column(name = "face_picture_url")
    private String facePictureUrl;

    /**
     * 人脸图片访问地址
     */
    @Column(name = "face_picture_pub_url")
    private String facePicturePubUrl;

    /**
     * 身份证正面图片地址
     */
    @Column(name = "id_positive_picture_url")
    private String idPositivePictureUrl;

    /**
     * 身份证正面图片访问地址
     */
    @Column(name = "id_positive_picture_pub_url")
    private String idPositivePicturePubUrl;

    /**
     * 身份证反面图片地址
     */
    @Column(name = "id_anti_picture_url")
    private String idAntiPictureUrl;

    /**
     * 身份证反面图片访问地址
     */
    @Column(name = "id_anti_picture_pub_url")
    private String idAntiPicturePubUrl;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

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
     * 获取人脸图片地址
     *
     * @return face_picture_url - 人脸图片地址
     */
    public String getFacePictureUrl() {
        return facePictureUrl;
    }

    /**
     * 设置人脸图片地址
     *
     * @param facePictureUrl 人脸图片地址
     */
    public void setFacePictureUrl(String facePictureUrl) {
        this.facePictureUrl = facePictureUrl;
    }

    /**
     * 获取人脸图片访问地址
     *
     * @return face_picture_pub_url - 人脸图片访问地址
     */
    public String getFacePicturePubUrl() {
        return facePicturePubUrl;
    }

    /**
     * 设置人脸图片访问地址
     *
     * @param facePicturePubUrl 人脸图片访问地址
     */
    public void setFacePicturePubUrl(String facePicturePubUrl) {
        this.facePicturePubUrl = facePicturePubUrl;
    }

    /**
     * 获取身份证正面图片地址
     *
     * @return id_positive_picture_url - 身份证正面图片地址
     */
    public String getIdPositivePictureUrl() {
        return idPositivePictureUrl;
    }

    /**
     * 设置身份证正面图片地址
     *
     * @param idPositivePictureUrl 身份证正面图片地址
     */
    public void setIdPositivePictureUrl(String idPositivePictureUrl) {
        this.idPositivePictureUrl = idPositivePictureUrl;
    }

    /**
     * 获取身份证正面图片访问地址
     *
     * @return id_positive_picture_pub_url - 身份证正面图片访问地址
     */
    public String getIdPositivePicturePubUrl() {
        return idPositivePicturePubUrl;
    }

    /**
     * 设置身份证正面图片访问地址
     *
     * @param idPositivePicturePubUrl 身份证正面图片访问地址
     */
    public void setIdPositivePicturePubUrl(String idPositivePicturePubUrl) {
        this.idPositivePicturePubUrl = idPositivePicturePubUrl;
    }

    /**
     * 获取身份证反面图片地址
     *
     * @return id_anti_picture_url - 身份证反面图片地址
     */
    public String getIdAntiPictureUrl() {
        return idAntiPictureUrl;
    }

    /**
     * 设置身份证反面图片地址
     *
     * @param idAntiPictureUrl 身份证反面图片地址
     */
    public void setIdAntiPictureUrl(String idAntiPictureUrl) {
        this.idAntiPictureUrl = idAntiPictureUrl;
    }

    /**
     * 获取身份证反面图片访问地址
     *
     * @return id_anti_picture_pub_url - 身份证反面图片访问地址
     */
    public String getIdAntiPicturePubUrl() {
        return idAntiPicturePubUrl;
    }

    /**
     * 设置身份证反面图片访问地址
     *
     * @param idAntiPicturePubUrl 身份证反面图片访问地址
     */
    public void setIdAntiPicturePubUrl(String idAntiPicturePubUrl) {
        this.idAntiPicturePubUrl = idAntiPicturePubUrl;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
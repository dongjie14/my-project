package com.easyget.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sys_region")
public class TSysRegion {
    /**
     * 地区码
     */
    @Id
    private Integer id;

    /**
     * 地区名称
     */
    private String name;

    /**
     * 上级ID
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 简称
     */
    @Column(name = "short_name")
    private String shortName;

    /**
     * 类型：0-国家，1-省，2-市，3-区县
     */
    @Column(name = "level_type")
    private Integer levelType;

    /**
     * 城市区号
     */
    @Column(name = "city_code")
    private String cityCode;

    /**
     * 邮政编码
     */
    @Column(name = "zip_code")
    private String zipCode;

    /**
     * 全称
     */
    @Column(name = "merge_name")
    private String mergeName;

    /**
     * 经度
     */
    private Float lng;

    /**
     * 维度
     */
    private Float lat;

    /**
     * 拼音
     */
    @Column(name = "pin_yin")
    private String pinYin;

    /**
     * 时间戳
     */
    @Column(name = "tm_smp")
    private Date tmSmp;

    /**
     * 获取地区码
     *
     * @return id - 地区码
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置地区码
     *
     * @param id 地区码
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取地区名称
     *
     * @return name - 地区名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置地区名称
     *
     * @param name 地区名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取上级ID
     *
     * @return parent_id - 上级ID
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置上级ID
     *
     * @param parentId 上级ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取简称
     *
     * @return short_name - 简称
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * 设置简称
     *
     * @param shortName 简称
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * 获取类型：0-国家，1-省，2-市，3-区县
     *
     * @return level_type - 类型：0-国家，1-省，2-市，3-区县
     */
    public Integer getLevelType() {
        return levelType;
    }

    /**
     * 设置类型：0-国家，1-省，2-市，3-区县
     *
     * @param levelType 类型：0-国家，1-省，2-市，3-区县
     */
    public void setLevelType(Integer levelType) {
        this.levelType = levelType;
    }

    /**
     * 获取城市区号
     *
     * @return city_code - 城市区号
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置城市区号
     *
     * @param cityCode 城市区号
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * 获取邮政编码
     *
     * @return zip_code - 邮政编码
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 设置邮政编码
     *
     * @param zipCode 邮政编码
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * 获取全称
     *
     * @return merge_name - 全称
     */
    public String getMergeName() {
        return mergeName;
    }

    /**
     * 设置全称
     *
     * @param mergeName 全称
     */
    public void setMergeName(String mergeName) {
        this.mergeName = mergeName;
    }

    /**
     * 获取经度
     *
     * @return lng - 经度
     */
    public Float getLng() {
        return lng;
    }

    /**
     * 设置经度
     *
     * @param lng 经度
     */
    public void setLng(Float lng) {
        this.lng = lng;
    }

    /**
     * 获取维度
     *
     * @return lat - 维度
     */
    public Float getLat() {
        return lat;
    }

    /**
     * 设置维度
     *
     * @param lat 维度
     */
    public void setLat(Float lat) {
        this.lat = lat;
    }

    /**
     * 获取拼音
     *
     * @return pin_yin - 拼音
     */
    public String getPinYin() {
        return pinYin;
    }

    /**
     * 设置拼音
     *
     * @param pinYin 拼音
     */
    public void setPinYin(String pinYin) {
        this.pinYin = pinYin;
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
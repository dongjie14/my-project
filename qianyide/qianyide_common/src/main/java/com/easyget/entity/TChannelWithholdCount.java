package com.easyget.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_channel_withhold_count")
public class TChannelWithholdCount {
    /**
     * 主键ID
     */
    @Id
    private Integer id;

    /**
     * 统计日期
     */
    @Column(name = "cut_date")
    private Date cutDate;

    /**
     * 渠道类型
     */
    @Column(name = "channel_type")
    private String channelType;

    /**
     * 代扣金额
     */
    @Column(name = "withhold_amt")
    private BigDecimal withholdAmt;

    /**
     * 时间戳
     */
    @Column(name = "tm_xmp")
    private Date tmXmp;

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
     * 获取统计日期
     *
     * @return cut_date - 统计日期
     */
    public Date getCutDate() {
        return cutDate;
    }

    /**
     * 设置统计日期
     *
     * @param cutDate 统计日期
     */
    public void setCutDate(Date cutDate) {
        this.cutDate = cutDate;
    }

    /**
     * 获取渠道类型
     *
     * @return channel_type - 渠道类型
     */
    public String getChannelType() {
        return channelType;
    }

    /**
     * 设置渠道类型
     *
     * @param channelType 渠道类型
     */
    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    /**
     * 获取代扣金额
     *
     * @return withhold_amt - 代扣金额
     */
    public BigDecimal getWithholdAmt() {
        return withholdAmt;
    }

    /**
     * 设置代扣金额
     *
     * @param withholdAmt 代扣金额
     */
    public void setWithholdAmt(BigDecimal withholdAmt) {
        this.withholdAmt = withholdAmt;
    }

    /**
     * 获取时间戳
     *
     * @return tm_xmp - 时间戳
     */
    public Date getTmXmp() {
        return tmXmp;
    }

    /**
     * 设置时间戳
     *
     * @param tmXmp 时间戳
     */
    public void setTmXmp(Date tmXmp) {
        this.tmXmp = tmXmp;
    }
}
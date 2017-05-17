package com.san.graduation.domain;

import javax.persistence.*;

@Table(name = "guide_order")
public class GuideOrder {
    /**
     * 发帖者
     */
    @Column(name = "send_no")
    private String sendNo;

    /**
     * 接受者
     */
    @Column(name = "recevier_no")
    private String recevierNo;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 获取发帖者
     *
     * @return send_no - 发帖者
     */
    public String getSendNo() {
        return sendNo;
    }

    /**
     * 设置发帖者
     *
     * @param sendNo 发帖者
     */
    public void setSendNo(String sendNo) {
        this.sendNo = sendNo;
    }

    /**
     * 获取接受者
     *
     * @return recevier_no - 接受者
     */
    public String getRecevierNo() {
        return recevierNo;
    }

    /**
     * 设置接受者
     *
     * @param recevierNo 接受者
     */
    public void setRecevierNo(String recevierNo) {
        this.recevierNo = recevierNo;
    }

    /**
     * 获取订单状态
     *
     * @return status - 订单状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置订单状态
     *
     * @param status 订单状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}
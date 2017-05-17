package com.san.graduation.domain;

import javax.persistence.*;

@Table(name = "help_order")
public class HelpOrder {
    /**
     * 发帖人编号
     */
    @Column(name = "send_no")
    private String sendNo;

    /**
     * 接收者编号
     */
    @Column(name = "recevier_no")
    private String recevierNo;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 获取发帖人编号
     *
     * @return send_no - 发帖人编号
     */
    public String getSendNo() {
        return sendNo;
    }

    /**
     * 设置发帖人编号
     *
     * @param sendNo 发帖人编号
     */
    public void setSendNo(String sendNo) {
        this.sendNo = sendNo;
    }

    /**
     * 获取接收者编号
     *
     * @return recevier_no - 接收者编号
     */
    public String getRecevierNo() {
        return recevierNo;
    }

    /**
     * 设置接收者编号
     *
     * @param recevierNo 接收者编号
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
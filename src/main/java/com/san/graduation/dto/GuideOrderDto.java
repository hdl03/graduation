package com.san.graduation.dto;

import com.san.graduation.common.BaseBean;

/**
 * Created by Administrator on 2017\5\29 0029.
 */
public class GuideOrderDto extends BaseBean {
    /**
     * 发帖者
     */
    private String sendNo;

    /**
     * 接受者
     */
    private String recevierNo;

    /**
     * 订单状态
     */
    private Integer status;
    /**
     * 关联学霸贴
     */
    private String guideTaskNo;



    public String getSendNo() {
        return sendNo;
    }

    public void setSendNo(String sendNo) {
        this.sendNo = sendNo;
    }

    public String getRecevierNo() {
        return recevierNo;
    }

    public void setRecevierNo(String recevierNo) {
        this.recevierNo = recevierNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getGuideTaskNo() {
        return guideTaskNo;
    }

    public void setGuideTaskNo(String guideTaskNo) {
        this.guideTaskNo = guideTaskNo;
    }
}

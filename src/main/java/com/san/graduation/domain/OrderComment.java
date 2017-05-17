package com.san.graduation.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "order_comment")
public class OrderComment {
    /**
     * 评论编号
     */
    @Column(name = "comment_no")
    private String commentNo;

    /**
     * 评论者
     */
    @Column(name = "comment_user_no")
    private String commentUserNo;

    /**
     * 订单类型
     */
    @Column(name = "order_type")
    private Integer orderType;

    /**
     * 分数
     */
    private Long score;

    /**
     * 评论时间
     */
    @Column(name = "comment_time")
    private Date commentTime;

    /**
     * 被评论者
     */
    @Column(name = "recevier_user_no")
    private String recevierUserNo;

    /**
     * 获取评论编号
     *
     * @return comment_no - 评论编号
     */
    public String getCommentNo() {
        return commentNo;
    }

    /**
     * 设置评论编号
     *
     * @param commentNo 评论编号
     */
    public void setCommentNo(String commentNo) {
        this.commentNo = commentNo;
    }

    /**
     * 获取评论者
     *
     * @return comment_user_no - 评论者
     */
    public String getCommentUserNo() {
        return commentUserNo;
    }

    /**
     * 设置评论者
     *
     * @param commentUserNo 评论者
     */
    public void setCommentUserNo(String commentUserNo) {
        this.commentUserNo = commentUserNo;
    }

    /**
     * 获取订单类型
     *
     * @return order_type - 订单类型
     */
    public Integer getOrderType() {
        return orderType;
    }

    /**
     * 设置订单类型
     *
     * @param orderType 订单类型
     */
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    /**
     * 获取分数
     *
     * @return score - 分数
     */
    public Long getScore() {
        return score;
    }

    /**
     * 设置分数
     *
     * @param score 分数
     */
    public void setScore(Long score) {
        this.score = score;
    }

    /**
     * 获取评论时间
     *
     * @return comment_time - 评论时间
     */
    public Date getCommentTime() {
        return commentTime;
    }

    /**
     * 设置评论时间
     *
     * @param commentTime 评论时间
     */
    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    /**
     * 获取被评论者
     *
     * @return recevier_user_no - 被评论者
     */
    public String getRecevierUserNo() {
        return recevierUserNo;
    }

    /**
     * 设置被评论者
     *
     * @param recevierUserNo 被评论者
     */
    public void setRecevierUserNo(String recevierUserNo) {
        this.recevierUserNo = recevierUserNo;
    }
}
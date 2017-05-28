package com.san.graduation.domain;

import javax.persistence.*;

@Table(name = "user_detail")
public class UserDetail extends BaseEntity {
    /**
     * 技能
     */
    private String skill;

    /**
     * 总共成交数
     */
    @Column(name = "total_task")
    private Integer totalTask;

    /**
     * 平均分
     */
    @Column(name = "avg_score")
    private Long avgScore;

    /**
     * 用户编号
     */
    @Column(name = "user_no")
    private String userNo;

    /**
     * 图片
     */
    private byte[] photo;

    /**
     * 介绍
     */
    private String introduction;

    /**
     * 获取技能
     *
     * @return skill - 技能
     */
    public String getSkill() {
        return skill;
    }

    /**
     * 设置技能
     *
     * @param skill 技能
     */
    public void setSkill(String skill) {
        this.skill = skill;
    }

    /**
     * 获取总共成交数
     *
     * @return total_task - 总共成交数
     */
    public Integer getTotalTask() {
        return totalTask;
    }

    /**
     * 设置总共成交数
     *
     * @param totalTask 总共成交数
     */
    public void setTotalTask(Integer totalTask) {
        this.totalTask = totalTask;
    }

    /**
     * 获取平均分
     *
     * @return avg_score - 平均分
     */
    public Long getAvgScore() {
        return avgScore;
    }

    /**
     * 设置平均分
     *
     * @param avgScore 平均分
     */
    public void setAvgScore(Long avgScore) {
        this.avgScore = avgScore;
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
     * 获取图片
     *
     * @return photo - 图片
     */
    public byte[] getPhoto() {
        return photo;
    }

    /**
     * 设置图片
     *
     * @param photo 图片
     */
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    /**
     * 获取介绍
     *
     * @return introduction - 介绍
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 设置介绍
     *
     * @param introduction 介绍
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
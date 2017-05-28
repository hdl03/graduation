package com.san.graduation.domain;

import javax.persistence.*;

@Table(name = "guide_task")
public class GuideTask extends BaseEntity {
    /**
     * 帖子编号
     */
    @Column(name = "task_no")
    private String taskNo;

    /**
     * 发帖标题
     */
    @Column(name = "task_title")
    private String taskTitle;

    /**
     * 发帖人
     */
    @Column(name = "user_no")
    private String userNo;

    /**
     * 标签（显示归属哪类）已逗号分隔
     */
    private String tag;

    /**
     * 最大名额
     */
    @Column(name = "max_number")
    private Integer maxNumber;

    /**
     * 已经招的人数
     */
    @Column(name = "already_number")
    private Integer alreadyNumber;

    /**
     * 帖子状态 0 正在 1 已经满额  2已经过期
     */
    @Column(name = "task_status")
    private Integer taskStatus;

    /**
     * 内容
     */
    @Column(name = "task_content")
    private String taskContent;

    /**
     * 获取帖子编号
     *
     * @return task_no - 帖子编号
     */
    public String getTaskNo() {
        return taskNo;
    }

    /**
     * 设置帖子编号
     *
     * @param taskNo 帖子编号
     */
    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    /**
     * 获取发帖标题
     *
     * @return task_title - 发帖标题
     */
    public String getTaskTitle() {
        return taskTitle;
    }

    /**
     * 设置发帖标题
     *
     * @param taskTitle 发帖标题
     */
    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    /**
     * 获取发帖人
     *
     * @return user_no - 发帖人
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     * 设置发帖人
     *
     * @param userNo 发帖人
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    /**
     * 获取标签（显示归属哪类）已逗号分隔
     *
     * @return tag - 标签（显示归属哪类）已逗号分隔
     */
    public String getTag() {
        return tag;
    }

    /**
     * 设置标签（显示归属哪类）已逗号分隔
     *
     * @param tag 标签（显示归属哪类）已逗号分隔
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * 获取最大名额
     *
     * @return max_number - 最大名额
     */
    public Integer getMaxNumber() {
        return maxNumber;
    }

    /**
     * 设置最大名额
     *
     * @param maxNumber 最大名额
     */
    public void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }

    /**
     * 获取已经招的人数
     *
     * @return already_number - 已经招的人数
     */
    public Integer getAlreadyNumber() {
        return alreadyNumber;
    }

    /**
     * 设置已经招的人数
     *
     * @param alreadyNumber 已经招的人数
     */
    public void setAlreadyNumber(Integer alreadyNumber) {
        this.alreadyNumber = alreadyNumber;
    }

    /**
     * 获取帖子状态 0 正在 1 已经满额  2已经过期
     *
     * @return task_status - 帖子状态 0 正在 1 已经满额  2已经过期
     */
    public Integer getTaskStatus() {
        return taskStatus;
    }

    /**
     * 设置帖子状态 0 正在 1 已经满额  2已经过期
     *
     * @param taskStatus 帖子状态 0 正在 1 已经满额  2已经过期
     */
    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    /**
     * 获取内容
     *
     * @return task_content - 内容
     */
    public String getTaskContent() {
        return taskContent;
    }

    /**
     * 设置内容
     *
     * @param taskContent 内容
     */
    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }
}
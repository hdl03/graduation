package com.san.graduation.domain;

import javax.persistence.*;

@Table(name = "guide_task")
public class GuideTask {
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
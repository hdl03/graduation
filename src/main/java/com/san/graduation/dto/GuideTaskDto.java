package com.san.graduation.dto;

import com.san.graduation.common.BaseBean;

import java.util.List;

/**
 * Created by Administrator on 2017\5\29 0029.
 */
public class GuideTaskDto extends BaseBean {

    /**
     * 帖子编号
     */

    private String taskNo;

    /**
     * 发帖标题
     */

    private String taskTitle;

    /**
     * 发帖人
     */

    private String userNo;

    /**
     * 标签（显示归属哪类）已逗号分隔
     */
    private String tag;

    /**
     * 最大名额
     */

    private Integer maxNumber;

    /**
     * 已经招的人数
     */

    private Integer alreadyNumber;

    /**
     * 帖子状态 0 正在 1 已经满额  2已经过期
     */

    private Integer taskStatus;

    /**
     * 内容
     */

    private String taskContent;

    List<GuideOrderDto> guideOrderDtos;

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }

    public Integer getAlreadyNumber() {
        return alreadyNumber;
    }

    public void setAlreadyNumber(Integer alreadyNumber) {
        this.alreadyNumber = alreadyNumber;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public List<GuideOrderDto> getGuideOrderDtos() {
        return guideOrderDtos;
    }

    public void setGuideOrderDtos(List<GuideOrderDto> guideOrderDtos) {
        this.guideOrderDtos = guideOrderDtos;
    }
}

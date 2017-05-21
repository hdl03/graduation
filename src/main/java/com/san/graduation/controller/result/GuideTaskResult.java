package com.san.graduation.controller.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.san.graduation.common.BaseBean;
import com.san.graduation.common.BaseResponse;
import com.san.graduation.common.error.Error;
import com.san.graduation.dto.PageDto;


import java.util.Date;
import java.util.List;

/**
 * Created by wuzr on 2017/5/20.
 * 学霸贴的返回结果
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GuideTaskResult extends BaseResponse{
    private List<Task> tasks;
    @JsonProperty("pageInfo")
    private PageDto pageDto;

    public PageDto getPageDto() {
        return pageDto;
    }

    public void setPageDto(PageDto pageDto) {
        this.pageDto = pageDto;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public static class Task extends BaseBean {
        private String taskNo;
        private String taskTitle;
        private String userNo;
        private String tag;
        private String taskContent;
        private Date createdAt;
        private String createdBy;

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

        public String getTaskContent() {
            return taskContent;
        }

        public void setTaskContent(String taskContent) {
            this.taskContent = taskContent;
        }

        public Date getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }
    }

    public static GuideTaskResult success(){
        GuideTaskResult result = new GuideTaskResult();
        result.setCode(Error.SUCCESS.getCode());
        result.setMessage(Error.SUCCESS.getMessage());
        return result;
    }
}

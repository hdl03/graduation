package com.san.graduation.controller.param;

import com.san.graduation.common.BaseParam;

/**
 * Created by wuzr on 2017/5/20.
 * 描述学渣贴请求参数
 */
public class HelpTaskParam extends BaseParam{
    private String taskTitle; //帖子标题
    private String tag; //帖子标签
    private String taskContent; //帖子内容

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public String getTaskTitle() {
        return taskTitle;

    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}

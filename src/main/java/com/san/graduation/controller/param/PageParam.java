package com.san.graduation.controller.param;

import com.san.graduation.common.BaseParam;

/**
 * Created by wuzr on 2017/5/20.
 * 分页查询请求参数
 */
public class PageParam extends BaseParam {
    private int startPage = 1;
    private int pageSize = 10;
    private String keyWord;

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}

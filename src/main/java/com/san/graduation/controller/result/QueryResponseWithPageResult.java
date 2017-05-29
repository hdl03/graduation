package com.san.graduation.controller.result;

import com.github.pagehelper.PageInfo;
import com.san.graduation.common.BaseResponse;
import com.san.graduation.common.error.Error;
import com.san.graduation.dto.PageDto;

/**
 * Created by Administrator on 2017\5\29 0029.
 */
public class QueryResponseWithPageResult extends BaseResponse {
    private Object data;
    private PageDto pageInfo;

    public static QueryResponseWithPageResult success(Object data, PageDto info) {
        QueryResponseWithPageResult responseResult = new QueryResponseWithPageResult();
        responseResult.setCode(Error.SUCCESS.getCode());
        responseResult.setMessage(Error.SUCCESS.getMessage());
        responseResult.setData(data);
        responseResult.setPageInfo(info);
        return responseResult;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public PageDto getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageDto pageInfo) {
        this.pageInfo = pageInfo;
    }
}

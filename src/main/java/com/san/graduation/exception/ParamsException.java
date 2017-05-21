package com.san.graduation.exception;

import com.san.graduation.common.error.Error;

/**
 * Created by wuzr on 2017/5/17.
 * 帖子参数异常
 */
public class ParamsException extends GraduaionException {


    @Override
    public Error getError() {
        return Error.PARAMS_ERROR;
    }

    @Override
    public String getErrorMessage() {
        return getError().getMessage();
    }
}

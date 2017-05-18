package com.san.graduation.exception;

import com.san.graduation.common.error.Error;

/**
 * Created by shanlin on 2017/5/18.
 */
public class NotExistUserException extends GraduaionException {
    @Override
    public Error getError() {
        return Error.NOT_EXIST_USER;
    }

    @Override
    public String getErrorMessage() {
        return Error.NOT_EXIST_USER.getMessage();
    }
}

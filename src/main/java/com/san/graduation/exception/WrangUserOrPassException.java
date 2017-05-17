package com.san.graduation.exception;

import com.san.graduation.common.error.Error;

/**
 * Created by shanlin on 2017/5/17.
 */
public class WrangUserOrPassException extends GraduaionException {
    @Override
    public Error getError() {
        return Error.WRANG_USER_OR_PASS;
    }

    @Override
    public String getErrorMessage() {
        return Error.WRANG_USER_OR_PASS.getMessage();
    }
}

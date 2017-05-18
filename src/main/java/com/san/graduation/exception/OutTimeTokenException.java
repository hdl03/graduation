package com.san.graduation.exception;

import com.san.graduation.common.error.Error;

/**
 * Created by shanlin on 2017/4/6.
 */
public class OutTimeTokenException extends GraduaionException {
    /**
     *
     */
    private static final long serialVersionUID = -7051836414685780479L;

    @Override
    public Error getError() {
        return Error.OUT_TIME_TOKEN;
    }

    @Override
    public String getErrorMessage() {
        return String.format(getError().getMessage());
    }
}

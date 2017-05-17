package com.san.graduation.exception;

import com.san.graduation.common.error.Error;

/**
 * Created by shanlin on 2017/5/17.
 */
public class ExistUserException extends GraduaionException{
    private String mobileNo;

    public ExistUserException(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public Error getError() {
        return Error.EXIST_USER;
    }

    @Override
    public String getErrorMessage() {
        return String.format(Error.EXIST_USER.getMessage(),this.mobileNo);
    }
}

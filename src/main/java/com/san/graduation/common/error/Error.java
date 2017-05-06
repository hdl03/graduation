package com.san.graduation.common.error;


/**
 * Created by huangdongliang on 2017/4/12.
 *
 * 异常同意放置地方
 */
public enum Error {
	  SUCCESS(ErrorCode.SUUCCESS, "success")
	  ,DOEXCEPTION(ErrorCode.DO_EXCEPTION,"操作异常");


    private String code;
    private String message;

    Error(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}

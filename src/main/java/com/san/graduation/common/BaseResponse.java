package com.san.graduation.common;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.san.graduation.common.error.Error;

/**
 * Created by huangdongliang on 16/12/5.
 */
@JsonSerialize
public class BaseResponse extends BaseBean {
    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BaseResponse() {
    }

    public BaseResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static BaseResponse ok() {
        return new BaseResponse(Error.SUCCESS.getCode(), Error.SUCCESS.getMessage());
    }

    public static BaseResponse fail(String code, String message) {
        return new BaseResponse(code, message);
    }

    public static BaseResponse failure() {
        return new BaseResponse(Error.DOEXCEPTION.getCode(), Error.DOEXCEPTION.getMessage());
    }

}

package com.san.graduation.common.error;


/**
 * Created by huangdongliang on 2017/4/12.
 * <p>
 * 异常同意放置地方
 */
public enum Error {
    SUCCESS(ErrorCode.SUUCCESS, "success"),
    DOEXCEPTION(ErrorCode.DO_EXCEPTION, "操作异常"),
    EXIST_USER(ErrorCode.EXIST_USER, "该[%s]用户已经存在"),
    WRANG_USER_OR_PASS(ErrorCode.WRANG_USER_OR_PASS,"错误的用户名或密码");


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

package com.san.graduation.exception;


import com.san.graduation.common.error.Error;

/**
 * Created by huangdongliang on 16/12/12.
 * 异常封装类，
 * 往外面抛异常，都需要继承这个抽象类
 *
 */
public abstract class GraduaionException extends RuntimeException {
    public GraduaionException() {
    }

    public GraduaionException(String message) {
        super(message);
    }

    public GraduaionException(String message, Throwable cause) {
        super(message, cause);
    }

    public GraduaionException(Throwable cause) {
        super(cause);
    }

    public GraduaionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }



    public abstract Error getError();

    public abstract String getErrorMessage();
}

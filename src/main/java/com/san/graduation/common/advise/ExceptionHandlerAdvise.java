package com.san.graduation.common.advise;

import com.san.graduation.common.BaseResponse;
import com.san.graduation.common.util.Logger;
import com.san.graduation.exception.GraduaionException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 对controller 统一做异常处理
 *
 */

@ControllerAdvice(annotations = {RestController.class})
public class ExceptionHandlerAdvise {

    @ExceptionHandler(GraduaionException.class)
    @Order(500)
    public ResponseEntity<BaseResponse> handleWandaException(GraduaionException ex) {
        // TODO
        return new ResponseEntity<BaseResponse>(BaseResponse.fail(ex.getError().getCode(), ex.getErrorMessage()), HttpStatus.OK);
    }

    @ExceptionHandler(RuntimeException.class)
    @Order(2000)
    public ResponseEntity<BaseResponse> handleWandaException(RuntimeException ex) {
        Logger.error(this, ex.getMessage(), ex);
        return new ResponseEntity<BaseResponse>(BaseResponse.failure(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


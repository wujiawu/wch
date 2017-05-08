package com.yw.wch.core;

import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

/**
 * 各种异常处理们
 * Created by wujiawu on 2017/5/7.
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String JSON_UTF_8 = "application/json; charset=UTF-8";

    /**
     * 处理 GlobalException
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<?> exceptionHandle(NativeWebRequest request, Exception e){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(JSON_UTF_8));
        String errorBody = JSON.toJSONString("{}");
        return handleExceptionInternal(e, errorBody,headers, HttpStatus.BAD_REQUEST,request);
    }


    /**
     * 处理JSR311 Validation异常.
     */
    @ExceptionHandler(value = {ConstraintViolationException.class})
    public final ResponseEntity<?> handleException(ConstraintViolationException ex, NativeWebRequest req) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(JSON_UTF_8));

        String errorBody = JSON.toJSONString("{}");

        return handleExceptionInternal(ex, errorBody, headers, HttpStatus.BAD_REQUEST, req);
    }


    /**
     * 处理 spring Assert 断言 抛出的异常
     */
    @ExceptionHandler(value = {IllegalArgumentException.class})
    public final ResponseEntity<?> handleException(IllegalArgumentException ex, NativeWebRequest req) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(JSON_UTF_8));

        String errorBody = JSON.toJSONString("{}");

        return handleExceptionInternal(ex, errorBody, headers, HttpStatus.BAD_REQUEST, req);
    }



}

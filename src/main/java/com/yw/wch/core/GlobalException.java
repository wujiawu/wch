package com.yw.wch.core;

import java.text.MessageFormat;

/**
 * 全局 RuntimeException
 */
public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 3583566093089790852L;

    private Long errorCode;

    public GlobalException() {
        super();
    }

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(long errorCode) {
        super(""+errorCode);
        this.errorCode = errorCode;
    }

    public GlobalException(Throwable cause) {
        super(cause);
    }

    public GlobalException(String message, Throwable cause) {
        super(message, cause);
    }


    public GlobalException(long errorCode, Throwable cause, String msg, Object... placeHoderVals){
        super(MessageFormat.format(msg,placeHoderVals),cause);
        this.errorCode = errorCode;
    }

    public GlobalException(long errorCode, String msg, Object... placeHoderVals){
        super(MessageFormat.format(msg,placeHoderVals));
        this.errorCode = errorCode;
    }

    public Long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(long errorCode) {
        this.errorCode = errorCode;
    }
}

package com.example.demo.service.aex;


/**
 * 数据不存在在异常
 */

public class NotException extends ServiceException{
    public NotException() {
        super();
    }

    public NotException(String message) {
        super(message);
    }

    public NotException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotException(Throwable cause) {
        super(cause);
    }

    protected NotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

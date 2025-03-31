package com.example.demo.service.aex;

// 插入数据的异常 */

public class InsException extends ServiceException {
    public InsException(String 未知的异常) {
        super();
    }

    public InsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsException(Throwable cause) {
        super(cause);
    }

    protected InsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}

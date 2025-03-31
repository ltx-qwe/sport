package com.example.demo.service.ex;

/**
 * 用户名被占用异常
 */
public class UsernameDuplicateException extends ServiceException{

    //alt+insert ----override methods

    public UsernameDuplicateException() {

        super();
    }

    public UsernameDuplicateException(String message) {
        super(message);
    }

    public UsernameDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameDuplicateException(Throwable cause) {
        super(cause);
    }

    protected UsernameDuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);

    }
}

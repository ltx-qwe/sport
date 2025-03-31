package com.example.demo.service.aex;

//题目被占用异常

public class WordException extends ServiceException {


    public WordException() {
        super();
    }

    public WordException(String message) {
        super(message);
    }

    public WordException(String message, Throwable cause) {
        super(message, cause);
    }

    public WordException(Throwable cause) {
        super(cause);
    }

    protected WordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

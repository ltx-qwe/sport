package com.example.demo.service.sex;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 运动员被占用异常
 */
public class SporterDuplicateException  extends ServiceException{
    public SporterDuplicateException() {
        super();
    }

    public SporterDuplicateException(String message) {
        super(message);
    }

    public SporterDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public SporterDuplicateException(Throwable cause) {
        super(cause);
    }

    protected SporterDuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}

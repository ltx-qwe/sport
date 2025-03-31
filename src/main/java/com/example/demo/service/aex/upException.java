package com.example.demo.service.aex;
/** 编辑==更新数据的异常 */
public class upException  extends ServiceException {
    public upException() {
        super();
    }

    public upException(String message) {
        super(message);
    }

    public upException(String message, Throwable cause) {
        super(message, cause);
    }

    public upException(Throwable cause) {
        super(cause);
    }

    protected upException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

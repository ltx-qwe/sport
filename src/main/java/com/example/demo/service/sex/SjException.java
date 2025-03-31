package com.example.demo.service.sex;
// 插入数据的异常 */
public class SjException  extends ServiceException{

    public SjException() {
        super();
    }

    public SjException(String message) {
        super(message);
    }

    public SjException(String message, Throwable cause) {
        super(message, cause);
    }

    public SjException(Throwable cause) {
        super(cause);
    }

    protected SjException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

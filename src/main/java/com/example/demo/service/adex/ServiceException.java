package com.example.demo.service.adex;
/**
 * 业务层异常的基类
 */
public class ServiceException extends RuntimeException{

    //重写父接口的 5 个构造方法（ctrl+o）

    public ServiceException() {//无参构造

        super();
    }

    public ServiceException(String message) {//抛出信息

        super(message);
    }

    public ServiceException(String message, Throwable cause) {//Throwable 是 RuntimeException 的父类

        super(message, cause);
    }

    public ServiceException(Throwable cause) {

        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {

        super(message, cause, enableSuppression, writableStackTrace);
    }

}

package com.example.demo.util;



import java.io.Serializable;
/**
 * Json 格式的数据进行响应
 * 泛型：当一个类中有泛型的数据类型，这个类声明时也要声明成泛型
 */
public class JsonResult<E> implements Serializable {
    //状态码
    private Integer state;
    //描述信息
    private String message;
    //数据：数据类型不确定，用泛型
    private E data;
    //定义构造方法，方便后期调用（根据参数不同进行调用）
    public JsonResult() {
    }
    public JsonResult(Integer state) {
        this.state = state;
    }
    /** 出现异常时调用 */
    public JsonResult(Throwable e) {
// 获取异常对象中的异常信息
        this.message = e.getMessage() ;
    }
    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public E getData() {
        return data;
    }
    public void setData(E data) {
        this.data = data;
    }
}
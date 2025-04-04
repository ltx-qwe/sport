package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

//作为所有实体类的基类
public class BaseEntity implements Serializable {


    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;
    /**
     * 方法分为三部分：1、私有属性的 getter、setter 方法
     * 2、equals 和 hashcode 方法
     * 3、toString 方法
     */
    public String getCreatedUser() {
        return createdUser;
    }
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }
    public Date getCreatedTime() {
        return createdTime;
    }
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
    public String getModifiedUser() {
        return modifiedUser;
    }
    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }
    public Date getModifiedTime() {
        return modifiedTime;
    }
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;
        BaseEntity that = (BaseEntity) o;
        if (getCreatedUser() != null ? !getCreatedUser().equals(that.getCreatedUser()) :
                that.getCreatedUser() != null)
            return false;
        if (getCreatedTime() != null ? !getCreatedTime().equals(that.getCreatedTime()) :
                that.getCreatedTime() != null)
            return false;
        if (getModifiedUser() !=
                null ? !getModifiedUser().equals(that.getModifiedUser()) : that.getModifiedUser() != null)
            return false;
        return getModifiedTime() != null ?
                getModifiedTime().equals(that.getModifiedTime()) : that.getModifiedTime() == null;
    }
    @Override
    public int hashCode() {
        int result = getCreatedUser() != null ? getCreatedUser().hashCode() : 0;
        result = 31 * result + (getCreatedTime() != null ? getCreatedTime().hashCode() :
                0);
        result = 31 * result + (getModifiedUser() != null ?
                getModifiedUser().hashCode() : 0);
        result = 31 * result + (getModifiedTime() != null ?
                getModifiedTime().hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "BaseEntity{" +
                "createdUser='" + createdUser + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                '}';
    }




}

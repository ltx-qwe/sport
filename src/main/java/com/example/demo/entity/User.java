package com.example.demo.entity;

import java.io.Serializable;
/**
 * 用户的实体类
 * 建议使用包装类定义，便于后期调用包装类相关的 api 做逻辑判断
 */
public class User extends BaseEntity implements Serializable {

     private Integer uid; //'用户 id'
     private String username; //'用户名'
     private String password; //'密码',
     private String salt; //'盐值',
     private String phone; //'电话号码',
     private String email; //'电子邮箱',
     private Integer gender; //'性别:0-女，1-男',
     private String avatar; //'头像',
     private Integer isDelete; //'是否删除：0-未删除，1-已删除',


    /**任何实体类都要有以下方法： 1、私有属性的 getter、setter 方法
     2、equals(比较两个对象是否相等，自定义比较规则)和
    hashcode 方法(地址输出)
    3、toString 方法（便于测试使用，输出对象）
            */

    public Integer getUid() {
        return uid;
    }
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSalt() {
        return salt;
    }
    public void setSalt(String salt) {
        this.salt = salt;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getGender() {
        return gender;
    }
    public void setGender(Integer gender) {
        this.gender = gender;
    }
    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public Integer getIsDelete() {
        return isDelete;
    }
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        if (getUid() != null ? !getUid().equals(user.getUid()) : user.getUid() != null) return
                false;
        if (getUsername() != null ? !getUsername().equals(user.getUsername()) :
                user.getUsername() != null)
            return false;
        if (getPassword() != null ? !getPassword().equals(user.getPassword()) :
                user.getPassword() != null)
            return false;
        if (getSalt() != null ? !getSalt().equals(user.getSalt()) : user.getSalt() != null) return
                false;
        if (getPhone() != null ? !getPhone().equals(user.getPhone()) : user.getPhone() !=
                null) return false;
        if (getEmail() != null ? !getEmail().equals(user.getEmail()) : user.getEmail() != null)
            return false;
        if (getGender() != null ? !getGender().equals(user.getGender()) : user.getGender() !=
                null) return false;
        if (getAvatar() != null ? !getAvatar().equals(user.getAvatar()) : user.getAvatar() !=
                null) return false;
        return getIsDelete() != null ? getIsDelete().equals(user.getIsDelete()) :
                user.getIsDelete() == null;
    }
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getUid() != null ? getUid().hashCode() : 0);
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getSalt() != null ? getSalt().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (getAvatar() != null ? getAvatar().hashCode() : 0);
        result = 31 * result + (getIsDelete() != null ? getIsDelete().hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", avatar='" + avatar + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
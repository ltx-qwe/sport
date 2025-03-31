package com.example.demo.entity;

import java.io.Serializable;
import java.util.Objects;

public class Admin  implements Serializable {
        private Integer id; //'用户 id'
        private String glname; //'用户名'

        private String yxi; //'
        private String phone; //
        private String email; //'

        private String gender;   //性别

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGlname() {
        return glname;
    }

    public void setGlname(String glname) {
        this.glname = glname;
    }

    public String getYxi() {
        return yxi;
    }

    public void setYxi(String yxi) {
        this.yxi = yxi;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin)) return false;
        Admin admin = (Admin) o;
        return Objects.equals(getId(), admin.getId()) && Objects.equals(getGlname(), admin.getGlname()) && Objects.equals(getYxi(), admin.getYxi()) && Objects.equals(getPhone(), admin.getPhone()) && Objects.equals(getEmail(), admin.getEmail()) && Objects.equals(getGender(), admin.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getGlname(), getYxi(), getPhone(), getEmail(), getGender());
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", glname='" + glname + '\'' +
                ", yxi='" + yxi + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

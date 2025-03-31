package com.example.demo.entity;

import java.io.Serializable;
import java.util.Objects;



public class Score  implements Serializable {
    private Integer id; //'用户 id'
    private String sporter; //'用户名'

    private String ssex; //'性别:',
    private String xm; //'比赛项目',
    private String score; //'比赛成绩',

    private String ti;   //比赛时间
    private String ran;  //排名

    /**任何实体类都要有以下方法： 1、私有属性的 getter、setter 方法
     2、equals(比较两个对象是否相等，自定义比较规则)和
     hashcode 方法(地址输出)
     3、toString 方法（便于测试使用，输出对象）
    **/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSporter() {
        return sporter;
    }

    public void setSporter(String sporter) {
        this.sporter = sporter;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTi() {
        return ti;
    }

    public void setTi(String ti) {
        this.ti = ti;
    }

    public String getRan() {
        return ran;
    }

    public void setRan(String ran) {
        this.ran = ran;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Score)) return false;
        Score score1 = (Score) o;
        return Objects.equals(getId(), score1.getId()) && Objects.equals(getSporter(), score1.getSporter()) && Objects.equals(getSsex(), score1.getSsex()) && Objects.equals(getXm(), score1.getXm()) && Objects.equals(getScore(), score1.getScore()) && Objects.equals(getTi(), score1.getTi()) && Objects.equals(getRan(), score1.getRan());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSporter(), getSsex(), getXm(), getScore(), getTi(), getRan());
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", sporter='" + sporter + '\'' +
                ", ssex='" + ssex + '\'' +
                ", xm='" + xm + '\'' +
                ", score='" + score + '\'' +
                ", time='" + ti+ '\'' +
                ", ran='" + ran + '\'' +
                '}';
    }
}
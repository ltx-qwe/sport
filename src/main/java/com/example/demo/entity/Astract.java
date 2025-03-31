package com.example.demo.entity;

import java.io.Serializable;

public class Astract extends BaseEntity implements Serializable {
    private Integer id; //'题号id'
    private String word ; //'题目'
    private String anwser; //'答案',
    private String diff; //'难易程度',
    private Integer num; //'空格数',

    private Integer score;

    public Astract(int id, String word, String anwser) {
        super();
    }

    public Astract() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getAnwser() {
        return anwser;
    }

    public void setAnwser(String anwser) {
        this.anwser = anwser;
    }

    public String getDiff() {
        return diff;
    }

    public void setDiff(String diff) {
        this.diff = diff;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer isDelete) {
        this.score = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Astract)) return false;
        if (!super.equals(o)) return false;

        Astract astract = (Astract) o;

        if (getId() != null ? !getId().equals(astract.getId()) : astract.getId() != null) return
                false;
        if (getWord() != null ? !getWord().equals(astract.getWord()) :
                astract.getWord() != null)
            return false;
        if (getAnwser() != null ? !getAnwser() .equals(astract.getAnwser() ) :
                astract.getAnwser() != null)
            return false;
        if (getDiff() != null ? !getDiff().equals(astract.getDiff()) : astract.getDiff() != null) return
                false;
        if (getNum() != null ? !getNum().equals(astract.getNum()) : astract.getNum() !=
                null) return false;

        return getScore() != null ? getScore().equals(astract.getScore()) :
               astract.getScore() == null;
    }




    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getWord() != null ? getWord().hashCode() : 0);
        result = 31 * result + (getAnwser()!= null ? getAnwser().hashCode() : 0);
        result = 31 * result + (getDiff() != null ? getDiff().hashCode() : 0);
        result = 31 * result + (getNum() != null ?getNum().hashCode() : 0);

        result = 31 * result + (getScore() != null ? getScore().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Astract{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", anwser='" + anwser + '\'' +
                ", diff='" + diff + '\'' +
                ", num=" + num +
                ", isDelete=" + score +
                '}';
    }
}






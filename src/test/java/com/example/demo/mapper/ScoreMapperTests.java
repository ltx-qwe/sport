package com.example.demo.mapper;

import com.example.demo.entity.Score;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ScoreMapperTests {
    @Autowired
    private ScoreMapper scoreMapper;
    @Test
    public void findAdd(){
        //添加成绩
        Score score=new Score();
//        score.setId(1);
        score.setSporter("l");
        score.setSsex("nan");
        score.setScore("8'12s");
        score.setXm("100m");
        score.setRan("8");
        score.setTi("2024-6-24");
       Integer rows = scoreMapper.findAdd(score);
        System.out.println(rows);
    }
    @Test
    public void findBySportName(){

        Score score =scoreMapper.findBySportName("li");
        System.out.println(score);

    }


    //查询所有
    @Test
    public  void findAll(){

        System.out.println(scoreMapper.findAll());

    }


}

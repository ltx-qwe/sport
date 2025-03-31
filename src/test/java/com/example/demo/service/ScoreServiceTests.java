package com.example.demo.service;


import com.example.demo.entity.Score;
import com.example.demo.service.sex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ScoreServiceTests {
    @Autowired
    private IScoreService iScoreService;

    @Test
    public void add(){
        try {
            Score score = new Score();
            score .setSporter("lower");
            score .setSsex("123");
            score.setScore("6'5s");
            score.setXm("100m");
            score.setRan("4");
            score.setTi("2024-6-23");
            iScoreService.add(score);

            System.out.println("ok");
        }catch (ServiceException e){
//获取类的对象，再获取类的名称
            System.out.println("添加失败！"+e.getClass().getSimpleName());
//获取类的具体描述信息
            System.out.println(e.getMessage());
        }
    }

    //查询

    @Test
    public void findAll(){
        try {
         Integer id= 1;
            iScoreService.findAll();
            System.out.println("ok");
        }catch (ServiceException e){
//获取类的对象，再获取类的名称
            System.out.println("添加失败！"+e.getClass().getSimpleName());
//获取类的具体描述信息
            System.out.println(e.getMessage());
        }
    }

}

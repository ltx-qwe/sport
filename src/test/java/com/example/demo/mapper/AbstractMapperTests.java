package com.example.demo.mapper;


import com.example.demo.entity.Astract;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class AbstractMapperTests {

    @Autowired
   private AstractMapper astractMapper;
    @Test

    public void sert(){
//添加题目
        Astract
        astract = new Astract();
        astract.setId(2946);
        astract.setWord("① 、② 和 ③ 三个阶段.");
        astract.setAnwser(" ①工管理    ②文件系统    ②数据库系统");
//        astract.setS("易");
        astract.setDiff("易");
        astract.setNum(3);
        Integer rows = astractMapper.sert(astract);
        System.out.println(rows);
    }


    @Test
    public void findByWord(){
        Astract astract= astractMapper.findByWord(" 数据管理技术经历了①、② 和 ③ 个阶段.");
        System.out.println(astract);
    }


//查询所有
    @Test
    public  void findAll(){

        System.out.println(astractMapper.findAll());

    }


    @Test
    public void findId() {
        Integer id = 14;
        Astract result = astractMapper.findId(id);
        System.out.println(result);
    }

    @Test
    public void updateId() {
       Astract a  = new Astract();
       a.setId(3);
        a.setWord("17858802222");
        a.setAnwser("gg");
       a.setDiff("admin@cy.com");
       a.setNum(1);
//        a.setModifiedUser("系统管理员");
       a.setModifiedTime(new Date());
        Integer rows = astractMapper.updateId(a);
        System.out.println("rows=" + rows);
    }
    //删除
    @Test
    public void deleteId() {
       astractMapper.deleteId(3);
    }
}

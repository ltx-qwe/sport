package com.example.demo.mapper;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Score;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class AdminMapperTests {



    @Autowired
    private AdminMapper adminMapper;
    @Test
    public void findAdd(){
        //添加成绩
        Admin admin =new Admin();
//        score.setId(1);
        admin.setGlname("谷歌");
        admin.setYxi("数学与大数据");

        Integer rows = adminMapper.findAdd(admin);
        System.out.println(rows);
    }
    @Test
    public void findName(){

        Score score =adminMapper.findName("谷歌");
        System.out.println(score);

    }


    //查询所有
    @Test
    public  void findAll(){

        System.out.println(adminMapper.findAll());

    }


}

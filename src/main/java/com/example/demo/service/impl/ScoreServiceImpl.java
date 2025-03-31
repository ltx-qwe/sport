package com.example.demo.service.impl;

import com.example.demo.entity.Score;
import com.example.demo.mapper.ScoreMapper;
import com.example.demo.service.IScoreService;
import com.example.demo.service.sex.SjException;
import com.example.demo.service.sex.SporterDuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//Service 注解，将当前类的对象交给 spring 来管理，自动创建类的对象以及对象的维护
public class ScoreServiceImpl implements IScoreService {


    @Autowired
    private ScoreMapper scoreMapper;
//添加成绩
    @Override
    public void add(Score score) {

        String sporter = score.getSporter();
        //调用 findBySportName（name）判断是否被add过
        Score result = scoreMapper.findBySportName(sporter);

        if (result != null){
           //抛出异常
            throw new SporterDuplicateException("用户名被占用");
        }
        //执行注册业务功能的实现（rows==1）
        Integer rows = scoreMapper.findAdd(score);
        if (rows != 1){
            throw new SjException("在用户添加过程中产生了未知的异常");
        }

    }






    @Override
    public List < Score > findAll() {

        return scoreMapper.findAll();
    }
}

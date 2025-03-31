package com.example.demo.service;

import com.example.demo.entity.Astract;
import com.example.demo.entity.Score;

import java.util.List;

public interface IScoreService {


    void add(Score score);


    //获取所有
    List < Score > findAll();
}

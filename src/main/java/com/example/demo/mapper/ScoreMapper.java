package com.example.demo.mapper;

import com.example.demo.entity.Astract;
import com.example.demo.entity.Score;

import java.util.List;

public interface ScoreMapper {



   Integer findAdd(Score score);

    Score findBySportName(String name);

    //查询
    List < Score > findAll();
}

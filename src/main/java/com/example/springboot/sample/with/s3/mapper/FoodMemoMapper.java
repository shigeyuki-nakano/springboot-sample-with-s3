package com.example.springboot.sample.with.s3.mapper;

import com.example.springboot.sample.with.s3.entity.MemoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodMemoMapper {
    List<MemoEntity> findAll();
}

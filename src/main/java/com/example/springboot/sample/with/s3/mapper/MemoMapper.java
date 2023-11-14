package com.example.springboot.sample.with.s3.mapper;

import com.example.springboot.sample.with.s3.entity.MemoDetailEntity;
import com.example.springboot.sample.with.s3.entity.MemoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemoMapper {

    List<MemoDetailEntity> findAll();

    int register(@Param("entity") MemoEntity entity);
}

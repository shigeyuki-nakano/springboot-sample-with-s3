package com.example.springboot.sample.with.s3.mapper;

import com.example.springboot.sample.with.s3.entity.MemoDetailEntity;
import com.example.springboot.sample.with.s3.entity.MemoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemoMapper {

    Optional<MemoDetailEntity> findById(@Param("id") int id);

    List<MemoDetailEntity> findAll();

    int register(@Param("entity") MemoEntity entity);

    int deleteById(@Param("id") int id);
}

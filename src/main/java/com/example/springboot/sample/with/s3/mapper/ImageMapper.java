package com.example.springboot.sample.with.s3.mapper;

import com.example.springboot.sample.with.s3.entity.ImageEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ImageMapper {

    int register(@Param("entity") ImageEntity entity);
}

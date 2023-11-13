package com.example.springboot.sample.with.s3.repository;

import com.example.springboot.sample.with.s3.dto.FoodMemo;

import java.util.List;

public interface FoodMemoRepository {
    List<FoodMemo> findAll();
}

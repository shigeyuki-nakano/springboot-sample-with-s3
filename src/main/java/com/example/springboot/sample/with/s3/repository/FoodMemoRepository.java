package com.example.springboot.sample.with.s3.repository;

import com.example.springboot.sample.with.s3.model.FoodMemo;

import java.util.List;
import java.util.Optional;

public interface FoodMemoRepository {

    Optional<FoodMemo> findById(int id);

    List<FoodMemo> findAll();

    void register(FoodMemo foodMemo);

    void deleteById(int id);
}

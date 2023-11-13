package com.example.springboot.sample.with.s3.repository.impl;

import com.example.springboot.sample.with.s3.dto.FoodMemo;
import com.example.springboot.sample.with.s3.entity.ImageEntity;
import com.example.springboot.sample.with.s3.mapper.FoodMemoMapper;
import com.example.springboot.sample.with.s3.repository.FoodMemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FoodMemoRepositoryImpl implements FoodMemoRepository {

    private final FoodMemoMapper foodMemoMapper;

    public List<FoodMemo> findAll() {
        final var entityList = foodMemoMapper.findAll();

        return entityList.stream()
                .map(entity -> FoodMemo.builder()
                        .id(entity.getId())
                        .title(entity.getTitle())
                        .content(entity.getContent())
                        .imagePaths(entity.getImages().stream()
                                .map(ImageEntity::getPath)
                                .toList())
                        .build())
                .toList();
    }
}

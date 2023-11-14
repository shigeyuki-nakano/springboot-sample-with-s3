package com.example.springboot.sample.with.s3.repository.impl;

import com.example.springboot.sample.with.s3.entity.ImageEntity;
import com.example.springboot.sample.with.s3.entity.MemoDetailEntity;
import com.example.springboot.sample.with.s3.entity.MemoEntity;
import com.example.springboot.sample.with.s3.mapper.ImageMapper;
import com.example.springboot.sample.with.s3.mapper.MemoMapper;
import com.example.springboot.sample.with.s3.model.FoodMemo;
import com.example.springboot.sample.with.s3.repository.FoodMemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FoodMemoRepositoryImpl implements FoodMemoRepository {

    private final MemoMapper memoMapper;
    private final ImageMapper imageMapper;

    public Optional<FoodMemo> findById(int id) {
        final var entity = memoMapper.findById(id);
        return entity.map(MemoDetailEntity::convert);
    }

    public List<FoodMemo> findAll() {
        final var entityList = memoMapper.findAll();

        return entityList.stream()
                .map(MemoDetailEntity::convert)
                .toList();
    }

    public void register(FoodMemo foodMemo) {
        final var memoEntity = MemoEntity.of(foodMemo);

        memoMapper.register(memoEntity);
        foodMemo.getImagePaths()
                .forEach(imagePath ->
                        imageMapper.register(ImageEntity.builder()
                                .memoId(memoEntity.getId())
                                .path(imagePath)
                                .build()));
    }

    public void deleteById(int id) {
        memoMapper.deleteById(id);
        imageMapper.deleteByMemoId(id);
    }
}

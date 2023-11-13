package com.example.springboot.sample.with.s3.service;

import com.example.springboot.sample.with.s3.dto.FoodMemo;
import com.example.springboot.sample.with.s3.repository.FoodMemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodMemoService {

    private final FoodMemoRepository foodMemoRepository;

    public List<FoodMemo> findAll() {
        return foodMemoRepository.findAll();
    }
}

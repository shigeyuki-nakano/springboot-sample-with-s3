package com.example.springboot.sample.with.s3.service;

import com.example.springboot.sample.with.s3.dto.FoodMemo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodMemoService {

    public List<FoodMemo> findAll() {
        return List.of(FoodMemo.builder()
                .id(1)
                .title("test")
                .content("test content")
                .imagePaths(List.of("https://1.bp.blogspot.com/-PjZz2WJ1Zj0/VMIvCILIJzI/AAAAAAAAq2w/bmdFdi5l4Z4/s800/fish_neontetra.png"))
                .build());
    }
}

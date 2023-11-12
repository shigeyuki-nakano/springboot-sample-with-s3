package com.example.springboot.sample.with.s3.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FoodMemo {

    private int id;
    private String title;
    private String content;
    private List<String> imagePaths;
}

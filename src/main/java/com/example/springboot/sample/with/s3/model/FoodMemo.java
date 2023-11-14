package com.example.springboot.sample.with.s3.model;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class FoodMemo {

    Integer id;
    @NonNull
    String title;
    @NonNull
    String content;
    @NonNull
    List<String> imagePaths;
}

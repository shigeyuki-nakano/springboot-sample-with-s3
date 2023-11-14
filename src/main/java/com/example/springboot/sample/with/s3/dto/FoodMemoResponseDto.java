package com.example.springboot.sample.with.s3.dto;

import com.example.springboot.sample.with.s3.model.FoodMemo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodMemoResponseDto {

    private int id;
    private String title;
    private String content;
    private List<String> imagePaths;

    public static FoodMemoResponseDto of(FoodMemo model) {
        return FoodMemoResponseDto.builder()
                .id(model.getId())
                .title(model.getTitle())
                .content(model.getContent())
                .imagePaths(model.getImagePaths())
                .build();
    }
}

package com.example.springboot.sample.with.s3.entity;

import com.example.springboot.sample.with.s3.model.FoodMemo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemoDetailEntity {

    private int id;
    private String title;
    private String content;
    private List<ImageEntity> images;

    public FoodMemo convert() {
        return FoodMemo.builder()
                .id(id)
                .title(title)
                .content(content)
                .imagePaths(images.stream()
                        .map(ImageEntity::getPath)
                        .toList())
                .build();
    }
}

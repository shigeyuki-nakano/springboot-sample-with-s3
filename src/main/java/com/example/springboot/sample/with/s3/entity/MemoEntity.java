package com.example.springboot.sample.with.s3.entity;

import com.example.springboot.sample.with.s3.model.FoodMemo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemoEntity {

    private Integer id;
    private String title;
    private String content;

    public static MemoEntity of(FoodMemo foodMemo) {
        return MemoEntity.builder()
                .content(foodMemo.getContent())
                .title(foodMemo.getTitle())
                .build();
    }
}

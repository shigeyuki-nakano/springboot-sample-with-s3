package com.example.springboot.sample.with.s3.entity;

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
}

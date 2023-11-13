package com.example.springboot.sample.with.s3.entity;

import lombok.Data;

import java.util.List;

@Data
public class MemoEntity {

    private int id;
    private String title;
    private String content;
    private List<ImageEntity> images;
}

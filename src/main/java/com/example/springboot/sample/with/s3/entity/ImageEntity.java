package com.example.springboot.sample.with.s3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageEntity {

    private Integer id;
    private int memoId;
    private String path;
}

package com.example.springboot.sample.with.s3.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class FoodMemoRegisterRequestDto {

    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    private List<MultipartFile> imageDataList;
}

package com.example.springboot.sample.with.s3.service;

import com.example.springboot.sample.with.s3.converter.MultipartFileToFileConverter;
import com.example.springboot.sample.with.s3.dto.FoodMemoRegisterRequestDto;
import com.example.springboot.sample.with.s3.dto.FoodMemoResponseDto;
import com.example.springboot.sample.with.s3.model.FoodMemo;
import com.example.springboot.sample.with.s3.repository.AssetRepository;
import com.example.springboot.sample.with.s3.repository.FoodMemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodMemoService {

    private final FoodMemoRepository foodMemoRepository;
    private final AssetRepository assetRepository;
    private final MultipartFileToFileConverter multipartFileToFileConverter;

    public List<FoodMemoResponseDto> findAll() {
        final var result = foodMemoRepository.findAll();
        return result.stream()
                .map(FoodMemoResponseDto::of)
                .toList();
    }

    public void register(FoodMemoRegisterRequestDto request) {
        final var imageFileList = request.getImageDataList().stream()
                .map(multipartFileToFileConverter::convert)
                .toList();

        final var imagePaths = imageFileList.stream()
                .map(assetRepository::upload)
                .toList();
        foodMemoRepository.register(FoodMemo.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .imagePaths(imagePaths)
                .build());
    }
}

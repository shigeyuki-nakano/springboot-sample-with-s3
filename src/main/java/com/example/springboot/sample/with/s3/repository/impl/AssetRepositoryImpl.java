package com.example.springboot.sample.with.s3.repository.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.springboot.sample.with.s3.config.S3Config;
import com.example.springboot.sample.with.s3.repository.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.File;

@Repository
@RequiredArgsConstructor
public class AssetRepositoryImpl implements AssetRepository {

    private final AmazonS3 s3Client;
    private final S3Config s3Config;
    private static final String BASE_KEY = "food_memo/";

    public String upload(File file) {
        final var objectKey = BASE_KEY + file.getName();
        final var request = new PutObjectRequest(
                s3Config.getBucketName(),
                objectKey,
                file);
        s3Client.putObject(request);

        return s3Config.getWebEndpoint() + "/" + objectKey;
    }
}

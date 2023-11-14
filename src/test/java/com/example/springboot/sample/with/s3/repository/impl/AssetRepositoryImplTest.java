package com.example.springboot.sample.with.s3.repository.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.springboot.sample.with.s3.config.S3Config;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AssetRepositoryImplTest {

    @InjectMocks
    AssetRepositoryImpl testSuite;
    @Mock
    AmazonS3 s3Client;
    @Mock
    S3Config s3Config;
    private static final String BASE_KEY = "food_memo/";

    @Nested
    @DisplayName("アップロード")
    class Upload {

        @Test
        @DisplayName("正常系")
        void case1() {
            // init
            final var file = new File("test");
            final var bucketName = "bucketName";
            final var webEndpoint = "https://webEndpoint";

            when(s3Config.getBucketName())
                    .thenReturn(bucketName);
            when(s3Config.getWebEndpoint())
                    .thenReturn(webEndpoint);

            // do
            final var actual = testSuite.upload(file);

            // assert
            Assertions.assertEquals(webEndpoint + "/" + BASE_KEY + file.getName(), actual);
            verify(s3Client, times(1)).putObject(isA(PutObjectRequest.class));
        }
    }
}

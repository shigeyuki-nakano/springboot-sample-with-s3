package com.example.springboot.sample.with.s3.client;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.example.springboot.sample.with.s3.config.AwsCredentialConfig;
import com.example.springboot.sample.with.s3.config.S3Config;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("local")
@Configuration
@RequiredArgsConstructor
public class S3LocalClient {

    private final S3Config s3Config;
    private final AwsCredentialConfig awsCredentialConfig;

    @Bean
    public AmazonS3 getS3Client() {
        return AmazonS3ClientBuilder
                .standard()
                .withRegion(s3Config.getRegion())
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentialConfig.getBasicAWSCredentials()))
                .build();
    }
}

package com.example.springboot.sample.with.s3.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "aws.s3")
public class S3Config {

    private String region;
    private String bucketName;

    public String getWebEndpoint() {
        return "https://" + bucketName + ".s3.ap-northeast-1.amazonaws.com";
    }
}

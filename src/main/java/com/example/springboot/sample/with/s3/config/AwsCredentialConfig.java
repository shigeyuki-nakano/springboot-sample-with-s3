package com.example.springboot.sample.with.s3.config;

import com.amazonaws.auth.BasicAWSCredentials;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "aws.credential")
public class AwsCredentialConfig {

    private String accessKey;
    private String secretKey;

    private BasicAWSCredentials basicAWSCredentials;

    @PostConstruct
    void init() {
        basicAWSCredentials = new BasicAWSCredentials(accessKey, secretKey);
    }
}

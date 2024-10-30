package com.ssafy.exam.config.aws;

import com.ssafy.exam.model.service.aws.AwsService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3Configuration;

import java.net.URI;

@Configuration
public class AwsConfig {
    @Value("${aws.s3.access-key-id}")
    private String accessKeyId;

    @Value("${aws.s3.secret-access-key}")
    private String secretAccessKey;

    @Value("${aws.s3.region}")
    private String region;

    @Value("${aws.s3.endpoint}")
    private String endpoint;
    @PostConstruct
    public void init() {
        System.out.println("accessKeyId:"+accessKeyId);
        System.out.println("secretAccessKey:"+secretAccessKey);
        System.out.println("region:"+region);
    }

    @Bean
    public S3Client s3Client() {
        return S3Client.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKeyId, secretAccessKey)))
                .endpointOverride(URI.create("https://" + endpoint))  // 명시적으로 엔드포인트 설정
                .serviceConfiguration(S3Configuration.builder()
                        .pathStyleAccessEnabled(true) // 필요에 따라 path-style URL 사용
                        .build())
                .build();
    }
}
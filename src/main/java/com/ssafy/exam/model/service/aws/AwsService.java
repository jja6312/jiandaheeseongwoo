package com.ssafy.exam.model.service.aws;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import software.amazon.awssdk.core.sync.RequestBody;

import java.io.IOException;
import java.util.UUID;

@Service
public class AwsService {

    private final S3Client s3Client;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    public AwsService(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    public String uploadS3Image(MultipartFile image) {
        String uniqueFileName = UUID.randomUUID() + "_" + image.getOriginalFilename();

        try {
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(uniqueFileName)
                    .build();

            PutObjectResponse response = s3Client.putObject(putObjectRequest,
                    RequestBody.fromBytes(image.getBytes()));

            return "https://" + bucketName + ".s3.amazonaws.com/" + uniqueFileName;
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload image to S3", e);
        }
    }

}

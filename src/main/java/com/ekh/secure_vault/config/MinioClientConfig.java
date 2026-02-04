
package com.ekh.secure_vault.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.minio.MinioClient;

@Configuration
public class MinioClientConfig {
    @Value("${s3.endpoint}")
    private String ENDPOINT;

    @Value("${s3.secret-key}")
    private String SECRET_KEY;

    @Value("${s3.access-key}")
    private String ACCESS_KEY;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(ENDPOINT)
                .credentials(ACCESS_KEY, SECRET_KEY)
                .build();
    }
}
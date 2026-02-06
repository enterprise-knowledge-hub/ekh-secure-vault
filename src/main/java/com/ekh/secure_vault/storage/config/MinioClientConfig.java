
package com.ekh.secure_vault.storage.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.minio.MinioClient;

@Configuration
public class MinioClientConfig {
    @Value("${minio.endpoint}")
    private String ENDPOINT;

    @Value("${minio.secret-key}")
    private String SECRET_KEY;

    @Value("${minio.access-key}")
    private String ACCESS_KEY;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(ENDPOINT)
                .credentials(ACCESS_KEY, SECRET_KEY)
                .build();
    }
}
package com.ekh.secure_vault.storage.service;

import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.ekh.secure_vault.exceptions.StorageException;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StorageService {
    private final MinioClient minioClient;
    
    public void storeFile(String bucketName, String objectName, InputStream in, long size, String contentType) {
        try {
            minioClient.putObject(
                PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object(objectName)
                    .stream(in, size, -1)
                    .contentType(contentType != null ? contentType : "application/octet-stream")
                    .build()
            );
        } catch (Exception e) {
            throw new StorageException(
                String.format("Failed to store file [%s] in bucket [%s]", objectName, bucketName), 
                e
            );
        }
    }
}

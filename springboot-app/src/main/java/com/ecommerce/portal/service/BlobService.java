package com.ecommerce.portal.service;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BlobService {
    @Value("${azure.storage.connection-string}")
    private String connectionString;

    @Value("${azure.storage.container-name}")
    private String containerName;

    public String uploadFile(MultipartFile file) throws Exception {

        BlobContainerClient containerClient =
                new BlobServiceClientBuilder()
                        .connectionString(connectionString)
                        .buildClient()
                        .getBlobContainerClient(containerName);

        BlobClient blobClient = containerClient.getBlobClient(file.getOriginalFilename());

        blobClient.upload(file.getInputStream(), file.getSize(), true);

        return blobClient.getBlobUrl();
    }
}

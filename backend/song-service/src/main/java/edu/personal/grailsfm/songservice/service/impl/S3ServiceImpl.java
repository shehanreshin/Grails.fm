package edu.personal.grailsfm.songservice.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.StringUtils;
import edu.personal.grailsfm.songservice.config.S3Config;
import edu.personal.grailsfm.songservice.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3ServiceImpl implements S3Service {
    private final AmazonS3 amazonS3;
    private final S3Config s3Config;

    @Override
    public String uploadFile(MultipartFile file, String bucketName) throws IOException {
        if (file.isEmpty()) {
            throw new FileNotFoundException();
        }

        String fileId = UUID.randomUUID().toString();
        amazonS3.putObject(bucketName, fileId, file.getInputStream(), null);

        return fileId;
    }

    @Override
    public Resource downloadFile(String fileId) throws IOException {
        S3Object s3Object = amazonS3.getObject(fileId, s3Config.getBucketName());
        return new ByteArrayResource(s3Object.getObjectContent().readAllBytes());
    }
}

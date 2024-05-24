package edu.personal.grailsfm.songservice.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.util.StringUtils;
import edu.personal.grailsfm.songservice.config.S3Config;
import edu.personal.grailsfm.songservice.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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

    @Transactional
    @Override
    public String uploadFile(MultipartFile file, String bucketName) throws IOException {
        if (file.isEmpty()) {
            return "";
        }

        String filename = getUniqueFileName(file.getOriginalFilename());
        amazonS3.putObject(bucketName, filename, file.getInputStream(), null);

        return String.format("%s/%s/%s", s3Config.getAwsEndpoint(), bucketName, filename);
    }

    private String getUniqueFileName(String filename) {
        String newName = UUID.randomUUID().toString();
        return filename == null ? newName : newName + "-" + filename.toLowerCase().replace(" ", "-");
    }
}

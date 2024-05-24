package edu.personal.grailsfm.songservice.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface S3Service {
    String uploadFile(MultipartFile multipartFile, String bucketName) throws IOException;
}

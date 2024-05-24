package edu.personal.grailsfm.songservice.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface S3Service {
    String uploadFile(MultipartFile file, String bucketName) throws IOException;
    Resource downloadFile(String fileId) throws IOException;
}

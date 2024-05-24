package edu.personal.grailsfm.songservice.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.util.StringUtils;
import edu.personal.grailsfm.songservice.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3ServiceImpl implements S3Service {
    private final AmazonS3 amazonS3;

    @Transactional
    @Override
    public String uploadFile(MultipartFile multipartFile, String bucketName) throws IOException {
        if (multipartFile.isEmpty()) {
            return "";
        }

        final File file = convertMultiPartFileToFile(multipartFile);
        amazonS3.putObject(bucketName, file.getName(), file);

        String fileName = file.getName();
        file.deleteOnExit();

        return String.format("https://s3.amazonaws.com/%s/%s", bucketName, fileName);
    }

    private String getUniqueFileName(String filename) {
        String newName = UUID.randomUUID().toString();
        return filename == null ? newName : newName + "-" + filename.toLowerCase().replace(" ", "-");
    }

    private File convertMultiPartFileToFile(final MultipartFile multipartFile) throws IOException {
        final File file = new File(getUniqueFileName(multipartFile.getOriginalFilename()));

        final FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(multipartFile.getBytes());

        return file;
    }
}

package edu.personal.grailsfm.songservice.service.factory;

import edu.personal.grailsfm.songservice.service.AudioProcessorService;
import edu.personal.grailsfm.songservice.service.impl.WavAudioProcessorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
public class AudioProcessorServiceFactory {
    private final WavAudioProcessorServiceImpl wavAudioProcessorService;

    public AudioProcessorService create(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if ((fileName != null && fileName.isEmpty()) || !fileName.contains(".")) return null;

        String extension = fileName.strip().substring(fileName.lastIndexOf(".")+1);
        return switch (extension) {
            case "wav" -> wavAudioProcessorService;
            default -> null;
        };
    }
}

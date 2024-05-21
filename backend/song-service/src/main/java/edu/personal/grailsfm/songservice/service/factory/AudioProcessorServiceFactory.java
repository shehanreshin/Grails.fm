package edu.personal.grailsfm.songservice.service.factory;

import edu.personal.grailsfm.songservice.service.AudioProcessorService;
import edu.personal.grailsfm.songservice.service.impl.Mp3AudioProcessorServiceImpl;
import edu.personal.grailsfm.songservice.service.impl.WavAudioProcessorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
public class AudioProcessorServiceFactory {
    private final WavAudioProcessorServiceImpl wavAudioProcessorService;
    private final Mp3AudioProcessorServiceImpl mp3AudioProcessorService;

    public AudioProcessorService create(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (fileName.isBlank() || !fileName.contains(".")) return null;

        String extension = fileName.strip().substring(fileName.lastIndexOf(".")+1);
        return switch (extension) {
            case "wav" -> wavAudioProcessorService;
            case "mp3" -> mp3AudioProcessorService;
            default -> null;
        };
    }
}

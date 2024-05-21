package edu.personal.grailsfm.songservice.service.factory;

import edu.personal.grailsfm.songservice.service.AudioProcessorService;
import edu.personal.grailsfm.songservice.service.impl.WavAudioProcessorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.sampled.UnsupportedAudioFileException;

@Component
@RequiredArgsConstructor
public class AudioProcessorServiceFactory {
    private final WavAudioProcessorServiceImpl wavAudioProcessorService;

    public AudioProcessorService create(MultipartFile file) throws UnsupportedAudioFileException {
        String fileName = file.getOriginalFilename();
        if ((fileName != null && fileName.isEmpty()) || !fileName.contains(".")) return null;

        String extension = fileName.strip().substring(fileName.lastIndexOf(".")+1);
        return switch (extension) {
            case "wav" -> wavAudioProcessorService;
            default -> throw new UnsupportedAudioFileException("Audio upload failed due to unsupported format");
        };
    }
}

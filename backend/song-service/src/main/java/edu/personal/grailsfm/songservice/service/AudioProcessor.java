package edu.personal.grailsfm.songservice.service;

import org.springframework.web.multipart.MultipartFile;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public interface AudioProcessor {
    Float calculateDurationOfTrack(MultipartFile file) throws IOException, UnsupportedAudioFileException;
}

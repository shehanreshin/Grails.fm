package edu.personal.grailsfm.songservice.service;

import edu.personal.grailsfm.songservice.dto.CreateTrackDto;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public interface TrackService {
    Object createTrack(CreateTrackDto trackDto) throws UnsupportedAudioFileException, IOException;
}

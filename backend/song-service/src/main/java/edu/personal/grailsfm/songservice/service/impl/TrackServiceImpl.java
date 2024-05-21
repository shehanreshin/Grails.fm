package edu.personal.grailsfm.songservice.service.impl;

import edu.personal.grailsfm.songservice.dto.CreateTrackDto;
import edu.personal.grailsfm.songservice.service.AudioProcessor;
import edu.personal.grailsfm.songservice.service.TrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class TrackServiceImpl implements TrackService {
    private final AudioProcessor audioProcessor;

    @Override
    public Object createTrack(CreateTrackDto trackDto) throws UnsupportedAudioFileException, IOException {
        Float duration = audioProcessor.calculateDurationOfTrack(trackDto.file());
        return null;
    }
}

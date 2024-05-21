package edu.personal.grailsfm.songservice.service.impl;

import edu.personal.grailsfm.songservice.dto.CreateTrackDto;
import edu.personal.grailsfm.songservice.service.AudioProcessorService;
import edu.personal.grailsfm.songservice.service.TrackService;
import edu.personal.grailsfm.songservice.service.factory.AudioProcessorServiceFactory;
import edu.personal.grailsfm.songservice.util.mapper.TrackMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class TrackServiceImpl implements TrackService {
    private final AudioProcessorServiceFactory audioProcessorFactory;
    private final TrackMapper trackMapper;

    @Override
    public Object createTrack(CreateTrackDto trackDto) throws UnsupportedAudioFileException, IOException {
        AudioProcessorService audioProcessorService = audioProcessorFactory.create(trackDto.file());
        Float duration = audioProcessorService.calculateDurationOfTrack(trackDto.file());


        return null;
    }
}

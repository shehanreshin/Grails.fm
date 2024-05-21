package edu.personal.grailsfm.songservice.service.impl;

import edu.personal.grailsfm.songservice.dto.track.CreateTrackDto;
import edu.personal.grailsfm.songservice.entity.Track;
import edu.personal.grailsfm.songservice.repository.TrackRepository;
import edu.personal.grailsfm.songservice.service.AudioProcessorService;
import edu.personal.grailsfm.songservice.service.TrackService;
import edu.personal.grailsfm.songservice.service.factory.AudioProcessorServiceFactory;
import edu.personal.grailsfm.songservice.util.enums.TrackStatus;
import edu.personal.grailsfm.songservice.util.exception.common.DuplicateFieldException;
import edu.personal.grailsfm.songservice.util.exception.track.TrackCreationException;
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
    private final TrackRepository trackRepository;

    @Override
    public String createTrack(CreateTrackDto trackDto) throws UnsupportedAudioFileException, IOException {
        if (trackRepository.findIdByTitleAnAndArtistName(trackDto.title(), trackDto.artistName()).isPresent()) {
            throw new DuplicateFieldException("A track by the given name already exists for the given artist");
        }

        AudioProcessorService audioProcessorService = audioProcessorFactory.create(trackDto.file());
        Float duration = audioProcessorService.calculateDurationOfTrack(trackDto.file());

        Track track = trackMapper.map(Track.class, trackDto);
        track.setUri("this is a uri");
        track.setDuration(duration);
        track.setStatus(TrackStatus.ACTIVE);

        track = trackRepository.save(track);

        if (track.getId() == null) throw new TrackCreationException();
        return track.getId();
    }
}

package edu.personal.grailsfm.songservice.service.impl;

import edu.personal.grailsfm.songservice.dto.track.CreateTrackDto;
import edu.personal.grailsfm.songservice.dto.track.TrackResponseDto;
import edu.personal.grailsfm.songservice.entity.Track;
import edu.personal.grailsfm.songservice.repository.TrackRepository;
import edu.personal.grailsfm.songservice.service.AudioProcessorService;
import edu.personal.grailsfm.songservice.service.S3Service;
import edu.personal.grailsfm.songservice.service.TrackService;
import edu.personal.grailsfm.songservice.service.factory.AudioProcessorServiceFactory;
import edu.personal.grailsfm.songservice.util.enums.TrackStatus;
import edu.personal.grailsfm.songservice.util.exception.common.DuplicateFieldException;
import edu.personal.grailsfm.songservice.util.exception.common.ResourceNotFoundException;
import edu.personal.grailsfm.songservice.util.exception.track.TrackCreationException;
import edu.personal.grailsfm.songservice.util.mapper.TrackMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrackServiceImpl implements TrackService {
    private final AudioProcessorServiceFactory audioProcessorFactory;
    private final TrackMapper trackMapper;
    private final TrackRepository trackRepository;
    private final S3Service s3Service;

    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    @Override
    public String createTrack(CreateTrackDto trackDto) throws UnsupportedAudioFileException, IOException {
        if (trackRepository.findIdByTitleAndArtistName(trackDto.title(), trackDto.artistName()).isPresent()) {
            throw new DuplicateFieldException("A track by the given name already exists for the given artist");
        }

        AudioProcessorService audioProcessorService = audioProcessorFactory.create(trackDto.file());
        Float duration = audioProcessorService.calculateDurationOfTrack(trackDto.file());

        String fileId = s3Service.uploadFile(trackDto.file(), bucketName);

        Track track = trackMapper.map(Track.class, trackDto);
        track.setFileId(fileId);
        track.setDuration(duration);
        track.setStatus(TrackStatus.ACTIVE);
        track.setPlayCount(0L);

        Track savedTrack = trackRepository.save(track);

        if (savedTrack.getId() == null) throw new TrackCreationException();
        return savedTrack.getId();
    }

    @Override
    public List<String> findAllTracksOfArtist(String artistId) {
        return trackRepository.findIdsByArtistIdAndStatuses(artistId, new TrackStatus[]{TrackStatus.ACTIVE, TrackStatus.ARCHIVED}).stream()
                .map(TrackRepository.IdProjection::getId)
                .toList();
    }

    @Override
    public Resource findTrackFileByFileId(String fileId) throws IOException {
        return s3Service.downloadFile(fileId);
    }

    @Override
    public TrackResponseDto findTrackDetailsById(String id) {
        Optional<Track> track = trackRepository.findById(id);
        if (track.isEmpty()) throw new ResourceNotFoundException("Track not found");

        return trackMapper.map(TrackResponseDto.class, track.get());
    }

    @Override
    public List<TrackResponseDto> findTracksDetailsByIds(List<String> ids) {
        List<Track> tracks = ids.stream()
                .map(trackRepository::findById)
                .map(track -> track.orElseThrow(() -> new ResourceNotFoundException("Track not found")))
                .toList();

        return tracks.stream()
                .map(track -> trackMapper.map(TrackResponseDto.class, track))
                .toList();
    }
}

package edu.personal.grailsfm.songservice.service;

import edu.personal.grailsfm.songservice.dto.track.CreateTrackDto;
import edu.personal.grailsfm.songservice.dto.track.TrackResponseDto;
import org.springframework.core.io.Resource;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

public interface TrackService {
    String createTrack(CreateTrackDto trackDto) throws UnsupportedAudioFileException, IOException;

    List<String> findAllTracksOfArtist(String artistId);

    Resource findTrackFileByFileId(String fileId) throws IOException;

    TrackResponseDto findTrackDetailsById(String id);

    List<TrackResponseDto> findTracksDetailsByIds(List<String> ids);
}

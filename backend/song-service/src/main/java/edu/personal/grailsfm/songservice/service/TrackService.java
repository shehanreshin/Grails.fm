package edu.personal.grailsfm.songservice.service;

import edu.personal.grailsfm.songservice.dto.CreateTrackDto;
import org.springframework.web.multipart.MultipartFile;

public interface TrackService {
    Object createTrack(CreateTrackDto trackDto);
}

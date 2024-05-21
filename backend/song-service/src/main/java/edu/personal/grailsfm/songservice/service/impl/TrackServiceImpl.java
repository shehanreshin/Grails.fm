package edu.personal.grailsfm.songservice.service.impl;

import edu.personal.grailsfm.songservice.dto.CreateTrackDto;
import edu.personal.grailsfm.songservice.service.TrackService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TrackServiceImpl implements TrackService {
    @Override
    public Object createTrack(CreateTrackDto trackDto) {
        return null;
    }

    private Integer calculateDurationOfTrack(MultipartFile file) {
        return 0;
    }
}

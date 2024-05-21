package edu.personal.grailsfm.songservice.util.mapper;

import edu.personal.grailsfm.songservice.dto.CreateTrackDto;
import edu.personal.grailsfm.songservice.entity.Track;

public interface TrackMapper {
    Track map(Class<Track> type, CreateTrackDto trackDto);
}

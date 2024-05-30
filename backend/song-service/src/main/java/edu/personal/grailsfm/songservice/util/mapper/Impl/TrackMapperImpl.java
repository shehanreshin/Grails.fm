package edu.personal.grailsfm.songservice.util.mapper.Impl;

import edu.personal.grailsfm.songservice.dto.track.CreateTrackDto;
import edu.personal.grailsfm.songservice.dto.track.TrackResponseDto;
import edu.personal.grailsfm.songservice.entity.Track;
import edu.personal.grailsfm.songservice.util.mapper.TrackMapper;
import org.springframework.stereotype.Component;

@Component
public class TrackMapperImpl implements TrackMapper {
    @Override
    public Track map(Class<Track> type, CreateTrackDto trackDto) {
        return Track.builder()
                .title(trackDto.title())
                .artistId(trackDto.artistId())
                .artistName(trackDto.artistName())
                .description(trackDto.description())
                .genres(trackDto.genres())
                .build();
    }

    @Override
    public TrackResponseDto map(Class<TrackResponseDto> type, Track track) {
        return new TrackResponseDto(
                track.getTitle(),
                track.getArtistId(),
                track.getArtistName(),
                track.getDescription(),
                track.getDuration(),
                track.getPlayCount(),
                track.getFileId()
        );
    }
}

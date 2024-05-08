package edu.personal.grailsfm.artistservice.util.mapper.impl;

import edu.personal.grailsfm.artistservice.dto.artist.CreateArtistDto;
import edu.personal.grailsfm.artistservice.entity.Artist;
import edu.personal.grailsfm.artistservice.util.mapper.ArtistMapper;
import org.springframework.stereotype.Component;

@Component
public class ArtistMapperImpl implements ArtistMapper {
    @Override
    public Artist map(Class<Artist> type, CreateArtistDto artistDto) {
        return Artist.builder()
                .name(artistDto.name())
                .email(artistDto.email())
                .password(artistDto.password())
                .contactNumber(artistDto.contactNumber())
                .build();
    }
}

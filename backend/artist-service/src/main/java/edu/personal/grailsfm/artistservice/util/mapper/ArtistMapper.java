package edu.personal.grailsfm.artistservice.util.mapper;

import edu.personal.grailsfm.artistservice.dto.artist.CreateArtistDto;
import edu.personal.grailsfm.artistservice.entity.Artist;

public interface ArtistMapper {
    Artist map(Class<Artist> type, CreateArtistDto artistDto);
}

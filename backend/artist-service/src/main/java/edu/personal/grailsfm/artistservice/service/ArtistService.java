package edu.personal.grailsfm.artistservice.service;

import edu.personal.grailsfm.artistservice.dto.artist.CreateArtistDto;

public interface ArtistService {
    Long createArtist(CreateArtistDto artistDto);
}

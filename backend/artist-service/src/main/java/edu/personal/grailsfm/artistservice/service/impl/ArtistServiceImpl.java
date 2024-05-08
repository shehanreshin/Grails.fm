package edu.personal.grailsfm.artistservice.service.impl;

import edu.personal.grailsfm.artistservice.dto.artist.CreateArtistDto;
import edu.personal.grailsfm.artistservice.repository.ArtistRepository;
import edu.personal.grailsfm.artistservice.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;

    @Override
    public Long createArtist(CreateArtistDto artistDto) {
        return null;
    }
}

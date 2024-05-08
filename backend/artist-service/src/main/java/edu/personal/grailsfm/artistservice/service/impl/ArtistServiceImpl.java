package edu.personal.grailsfm.artistservice.service.impl;

import edu.personal.grailsfm.artistservice.dto.artist.CreateArtistDto;
import edu.personal.grailsfm.artistservice.entity.Artist;
import edu.personal.grailsfm.artistservice.repository.ArtistRepository;
import edu.personal.grailsfm.artistservice.service.ArtistService;
import edu.personal.grailsfm.artistservice.util.enums.ArtistAccountStatus;
import edu.personal.grailsfm.artistservice.util.exception.artist.ArtistCreationException;
import edu.personal.grailsfm.artistservice.util.exception.common.DuplicateFieldException;
import edu.personal.grailsfm.artistservice.util.mapper.ArtistMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;
    private final ArtistMapper artistMapper;

    @Override
    public Long createArtist(CreateArtistDto artistDto) {
        if (artistRepository.findIdByName(artistDto.name()).isPresent()) {
            throw new DuplicateFieldException("An artist by the given name is already registered");
        }

        if (artistRepository.findIdByEmail(artistDto.email()).isPresent()) {
            throw new DuplicateFieldException("Email is already registered");
        }

        Artist artist = artistMapper.map(Artist.class, artistDto);
        artist.setStatus(ArtistAccountStatus.CONFIRMATION_PENDING);

        Artist savedArtist = artistRepository.save(artist);

        if (savedArtist.getId() == null) {
            throw new ArtistCreationException();
        }

        return savedArtist.getId();
    }
}

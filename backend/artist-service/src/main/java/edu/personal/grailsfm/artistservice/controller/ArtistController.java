package edu.personal.grailsfm.artistservice.controller;

import edu.personal.grailsfm.artistservice.dto.artist.CreateArtistDto;
import edu.personal.grailsfm.artistservice.service.ArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artists")
public class ArtistController {
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping
    public ResponseEntity<Long> createArtist(@RequestBody CreateArtistDto artistDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(artistService.createArtist(artistDto));
    }
}

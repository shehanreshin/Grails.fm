package edu.personal.grailsfm.songservice.controller;

import edu.personal.grailsfm.songservice.dto.track.CreateTrackDto;
import edu.personal.grailsfm.songservice.dto.track.TrackResponseDto;
import edu.personal.grailsfm.songservice.service.TrackService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/tracks")
public class TrackController {
    private final TrackService trackService;

    @SneakyThrows
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> createTrack(@ModelAttribute CreateTrackDto trackDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(trackService.createTrack(trackDto));
    }

    @GetMapping("/artists/{id}")
    public ResponseEntity<List<String>> findAllTracksOfArtist(@PathVariable("id") String id) {
        return ResponseEntity.ok(trackService.findAllTracksOfArtist(id));
    }
}

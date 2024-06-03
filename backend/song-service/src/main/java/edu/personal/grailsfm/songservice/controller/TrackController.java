package edu.personal.grailsfm.songservice.controller;

import edu.personal.grailsfm.songservice.dto.track.CreateTrackDto;
import edu.personal.grailsfm.songservice.dto.track.TrackResponseDto;
import edu.personal.grailsfm.songservice.service.TrackService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @SneakyThrows
    @GetMapping("/file/{id}")
    public ResponseEntity<Resource> findTrackFileByFileId(@PathVariable("id") String id) {
        return ResponseEntity.ok(trackService.findTrackFileByFileId(id));
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<TrackResponseDto> findTrackById(@PathVariable("id") String id) {
        return ResponseEntity.ok(trackService.findTrackDetailsById(id));
    }

    @GetMapping("/details")
    public ResponseEntity<List<TrackResponseDto>> findTracksByIds(@RequestBody List<String> ids) {
        return ResponseEntity.ok(trackService.findTracksDetailsByIds(ids));
    }
}

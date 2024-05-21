package edu.personal.grailsfm.songservice.controller;

import edu.personal.grailsfm.songservice.dto.CreateTrackDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/tracks")
public class TrackController {
    private final TrackService trackService;

    @PostMapping
    public ResponseEntity<?> createTrack(@ModelAttribute CreateTrackDto trackDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(trackService.createTrack(trackDto));
    }
}

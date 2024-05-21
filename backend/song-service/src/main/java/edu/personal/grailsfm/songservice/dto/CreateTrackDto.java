package edu.personal.grailsfm.songservice.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record CreateTrackDto(
        String title,
        String artistId,
        String artistName,
        String description,
        MultipartFile file,
        List<String> genres
) {
}

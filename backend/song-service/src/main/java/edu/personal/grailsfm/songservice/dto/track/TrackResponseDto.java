package edu.personal.grailsfm.songservice.dto.track;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record TrackResponseDto(
        @Schema(example = "VOH")
        @NotBlank(message = "Title is mandatory")
        String title,

        @Schema(example = "664f12e6ec730435c9c8dae6")
        @NotBlank(message = "Artist ID is mandatory")
        String artistId,

        @Schema(example = "Kevin Penkin")
        @NotBlank(message = "Artist name is mandatory")
        String artistName,

        @Schema(example = "\"VOH\" isn't your typical melody. It's a descent into the dark wonder of Made in Abyss. Beauty and haunting vocals by Takeshi Saito weave a chilling lullaby, a siren song that both entices and terrifies. It's the thrill of discovery laced with the dread of the unknown, a soundscape reflecting the abyss's perilous depths. Buckle up for a wild ride.")
        @NotBlank(message = "Description is mandatory")
        String description,

        @Schema(example = "7.39")
        Float duration,

        @Schema(example = "13718")
        @PositiveOrZero(message = "Play count must be positive or zero")
        Long playCount,

        @Schema(example = "https://s3.amazonaws.com/openai-assets/research-covers/gpt-3.jpg")
        @NotBlank(message = "Path to the track is mandatory")
        String uri
) {
}

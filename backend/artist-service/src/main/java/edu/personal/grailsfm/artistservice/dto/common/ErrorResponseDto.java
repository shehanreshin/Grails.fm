package edu.personal.grailsfm.artistservice.dto.common;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

public record ErrorResponseDto(
        @NotBlank(message = "Message is mandatory") String message,
        @PastOrPresent Date date
) {
}

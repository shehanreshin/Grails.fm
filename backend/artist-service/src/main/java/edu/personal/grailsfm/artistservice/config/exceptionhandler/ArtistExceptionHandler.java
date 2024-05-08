package edu.personal.grailsfm.artistservice.config.exceptionhandler;

import edu.personal.grailsfm.artistservice.dto.common.ErrorResponseDto;
import edu.personal.grailsfm.artistservice.util.exception.artist.ArtistCreationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ArtistExceptionHandler {
    @ExceptionHandler(ArtistCreationException.class)
    public ResponseEntity<ErrorResponseDto> handleArtistCreationFailedException(ArtistCreationException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponseDto(ex.getMessage(), new Date()));
    }
}

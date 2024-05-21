package edu.personal.grailsfm.songservice.config.exceptionhandler;

import edu.personal.grailsfm.songservice.dto.common.ErrorResponseDto;
import edu.personal.grailsfm.songservice.util.exception.TrackCreationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class TrackExceptionHandler {
    @ExceptionHandler(TrackCreationException.class)
    public ResponseEntity<ErrorResponseDto> handleArtistCreationFailedException(TrackCreationException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponseDto(ex.getMessage(), new Date()));
    }
}

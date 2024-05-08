package edu.personal.grailsfm.artistservice.config.exceptionhandler;

import edu.personal.grailsfm.artistservice.dto.common.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {
    public ResponseEntity<ErrorResponseDto> handleInternalServerError(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponseDto(ex.getMessage(), new Date()));
    }
}

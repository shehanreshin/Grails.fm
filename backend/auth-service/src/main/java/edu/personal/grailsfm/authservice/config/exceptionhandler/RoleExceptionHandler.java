package edu.personal.grailsfm.authservice.config.exceptionhandler;

import edu.personal.grailsfm.authservice.dto.common.ErrorResponseDto;
import edu.personal.grailsfm.authservice.util.exception.role.InvalidRoleException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RoleExceptionHandler {

    @ExceptionHandler(InvalidRoleException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidRoleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorResponseDto(ex.getMessage(), new Date())
        );
    }
}

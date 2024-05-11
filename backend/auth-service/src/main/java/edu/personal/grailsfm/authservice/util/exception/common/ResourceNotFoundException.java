package edu.personal.grailsfm.authservice.util.exception.common;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

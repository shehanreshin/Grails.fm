package edu.personal.grailsfm.authservice.util.exception.role;

public class InvalidRoleException extends RuntimeException {
    public InvalidRoleException() {
        super("Invalid role");
    }
}

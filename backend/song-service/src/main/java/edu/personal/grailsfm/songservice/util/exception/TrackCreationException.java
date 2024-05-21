package edu.personal.grailsfm.songservice.util.exception;

public class TrackCreationException extends RuntimeException {
    public TrackCreationException() {
        super("Track creation failed due to an unexpected error.");
    }
}

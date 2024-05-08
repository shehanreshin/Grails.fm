package edu.personal.grailsfm.artistservice.util.exception.artist;

public class ArtistCreationException extends RuntimeException {
    public ArtistCreationException() {
        super("Artist creation failed due to an unexpected error.");
    }
}

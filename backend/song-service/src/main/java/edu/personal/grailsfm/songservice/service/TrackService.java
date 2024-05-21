package edu.personal.grailsfm.songservice.service;

import edu.personal.grailsfm.songservice.dto.track.CreateTrackDto;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public interface TrackService {
    String createTrack(CreateTrackDto trackDto) throws UnsupportedAudioFileException, IOException;
}

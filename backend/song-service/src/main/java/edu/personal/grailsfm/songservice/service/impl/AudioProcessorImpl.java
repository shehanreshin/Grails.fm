package edu.personal.grailsfm.songservice.service.impl;

import edu.personal.grailsfm.songservice.service.AudioProcessor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class AudioProcessorImpl implements AudioProcessor {
    @Override
    public Float calculateDurationOfTrack(MultipartFile file) throws IOException, UnsupportedAudioFileException {
        InputStream bufferedInputStream = new BufferedInputStream(file.getInputStream());
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedInputStream);

        AudioFormat format = audioInputStream.getFormat();
        long frames = audioInputStream.getFrameLength();
        float durationInSeconds = frames / format.getFrameRate();

        int minutes = (int) (durationInSeconds / 60);
        float seconds = (float) Math.floor(((durationInSeconds % 60) / 100) * 100) / 100;

        return minutes + seconds;
    }
}

package edu.personal.grailsfm.songservice.repository;

import edu.personal.grailsfm.songservice.entity.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends MongoRepository<Track, String> {
}

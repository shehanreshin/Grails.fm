package edu.personal.grailsfm.songservice.repository;

import edu.personal.grailsfm.songservice.entity.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrackRepository extends MongoRepository<Track, String> {
    @Query(value = "{title: ?0, artist_name: ?1}", fields = "{_id:  1}")
    Optional<String> findIdByTitleAnAndArtistName(String title, String artistName);
}

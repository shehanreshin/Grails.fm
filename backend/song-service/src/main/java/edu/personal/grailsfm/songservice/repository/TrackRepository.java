package edu.personal.grailsfm.songservice.repository;

import edu.personal.grailsfm.songservice.entity.Track;
import edu.personal.grailsfm.songservice.util.enums.TrackStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrackRepository extends MongoRepository<Track, String> {
    @Query(value = "{title: ?0, artist_name: ?1}", fields = "{_id:  1}")
    Optional<String> findIdByTitleAndArtistName(String title, String artistName);

    @Query(value = "{artist_id: ?0, status: {$in: ?1}}", fields = "{_id:  1}")
    List<IdProjection> findIdsByArtistIdAndStatuses(String artistId, TrackStatus[] status);

    interface IdProjection {
        String getId();
    }
}

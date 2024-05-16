package edu.personal.grailsfm.artistservice.repository;

import edu.personal.grailsfm.artistservice.entity.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends MongoRepository<Artist, String> {
    Optional<Long> findIdByEmail(String email);
    Optional<Long> findIdByName(String name);
}

package edu.personal.grailsfm.artistservice.repository;

import edu.personal.grailsfm.artistservice.entity.Artist;
import org.springframework.data.mongodb.core.annotation.Collation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends MongoRepository<Artist, String> {
    @Query(value = "{email: ?0}", fields = "{_id: 1}")
    Optional<String> findIdByEmail(String email);

    @Query(value = "{name: ?0}", fields = "{_id: 1}")
    Optional<String> findIdByName(String name);
}

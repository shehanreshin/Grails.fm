package edu.personal.grailsfm.artistservice.repository;

import edu.personal.grailsfm.artistservice.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    @Query(value = "SELECT id FROM artist WHERE email=:email", nativeQuery = true)
    Optional<Long> findIdByEmail(String email);

    @Query(value = "SELECT id FROM artist WHERE name=:name", nativeQuery = true)
    Optional<Long> findIdByName(String name);
}

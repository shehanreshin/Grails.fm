package edu.personal.grailsfm.artistservice.repository;

import edu.personal.grailsfm.artistservice.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}

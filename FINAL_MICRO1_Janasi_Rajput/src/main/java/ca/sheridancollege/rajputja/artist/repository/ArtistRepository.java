package ca.sheridancollege.rajputja.artist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.rajputja.artist.domain.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

}

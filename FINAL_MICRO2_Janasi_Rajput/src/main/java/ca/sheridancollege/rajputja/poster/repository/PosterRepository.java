package ca.sheridancollege.rajputja.poster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.rajputja.poster.data.Poster;

public interface PosterRepository extends JpaRepository<Poster, Long> {

}

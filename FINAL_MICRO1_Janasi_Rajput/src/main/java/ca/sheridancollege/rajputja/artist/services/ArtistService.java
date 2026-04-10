package ca.sheridancollege.rajputja.artist.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ca.sheridancollege.rajputja.artist.domain.Artist;

@Service
public interface ArtistService {
	public List<Artist> findAll();

    public Artist findById(Long id);

    public Artist save(Artist artist);

}

package ca.sheridancollege.rajputja.artist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.sheridancollege.rajputja.artist.domain.Artist;
import ca.sheridancollege.rajputja.artist.repository.ArtistRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ArtistServiceImp implements ArtistService {

    @Autowired
    private ArtistRepository artistRepo;

    @Override
    public List<Artist> findAll() {
        return artistRepo.findAll();
    }

    @Override
    public Artist findById(Long id) {
        Optional<Artist> artist = artistRepo.findById(id);
        return artist.orElse(null);
    }

    @Override
    public Artist save(Artist artist) {
        return artistRepo.save(artist);
    }
}
package ca.sheridancollege.rajputja.artist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import ca.sheridancollege.rajputja.artist.domain.Artist;
import ca.sheridancollege.rajputja.artist.services.ArtistService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/artists")
@AllArgsConstructor
public class ArtistRestController {

    private final ArtistService artistService;

    // GET all artists
    @GetMapping
    public List<Artist> getAllArtists() {
        return artistService.findAll();
    }

    // GET artist by id
    @GetMapping("/{id}")
    public Artist getArtistById(@PathVariable Long id) {
        return artistService.findById(id);
    }

    // POST new artist
    @PostMapping
    public Artist createArtist(@RequestBody Artist artist) {
        return artistService.save(artist);
    }
}
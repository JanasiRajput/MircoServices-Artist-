package ca.sheridancollege.rajputja.artist_controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.rajputja.artist.domain.Artist;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/gateway/artists")
public class ArtistGatewayController {

    private final RestTemplate restTemplate;

    // GET all artists
    @GetMapping
    public List<Artist> getAllArtists() {
        ResponseEntity<Artist[]> response = restTemplate.getForEntity("http://localhost:8081/api/v1/artists", Artist[].class);
        return Arrays.asList(response.getBody());
    }

    // GET artist by id
    @GetMapping("/{id}")
    public Artist getArtistById(@PathVariable Long id) {
        return restTemplate.getForObject("http://localhost:8081/api/v1/artists/" + id, Artist.class);
    }

    // POST new artist
    @PostMapping
    public Artist createArtist(@RequestBody Artist artist) {
        return restTemplate.postForObject("http://localhost:8081/api/v1/artists", artist, Artist.class);
    }
}
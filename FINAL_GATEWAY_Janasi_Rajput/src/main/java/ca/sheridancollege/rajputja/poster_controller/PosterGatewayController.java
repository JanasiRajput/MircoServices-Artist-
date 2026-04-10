package ca.sheridancollege.rajputja.poster_controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.rajputja.poster.data.Poster;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/gateway/posters")
public class PosterGatewayController {

    private final RestTemplate restTemplate;

    // GET all posters
    @GetMapping
    public List<Poster> getAllPosters() {
        ResponseEntity<Poster[]> response = restTemplate.getForEntity("http://localhost:8082/api/v1/posters", Poster[].class);
        return Arrays.asList(response.getBody());
    }

    // GET poster by id
    @GetMapping("/{id}")
    public Poster getPosterById(@PathVariable Long id) {
        return restTemplate.getForObject("http://localhost:8082/api/v1/posters/" + id, Poster.class);
    }

    // POST new poster
    @PostMapping
    public Poster createPoster(@RequestBody Poster poster) {
        return restTemplate.postForObject("http://localhost:8082/api/v1/posters", poster, Poster.class);
    }

    // PUT update poster
    @PutMapping("/{id}")
    public Poster updatePoster(@PathVariable Long id, @RequestBody Poster poster) {
        restTemplate.put("http://localhost:8082/api/v1/posters/" + id, poster);
        return getPosterById(id);
    }

    // DELETE poster
    @DeleteMapping("/{id}")
    public void deletePoster(@PathVariable Long id) {
        restTemplate.delete("http://localhost:8082/api/v1/posters/" + id);
    }

    // CUSTOM: Purchase Poster
    @PutMapping("/{id}/purchase")
    public Poster purchasePoster(@PathVariable Long id) {
        Poster poster = getPosterById(id);
        if (poster != null && poster.getQuantity() > 0) {
            poster.setQuantity(poster.getQuantity() - 1);
            restTemplate.put("http://localhost:8082/api/v1/posters/" + id, poster);
        }
        return poster;
    }
}
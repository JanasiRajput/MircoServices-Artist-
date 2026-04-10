package ca.sheridancollege.rajputja.poster.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import ca.sheridancollege.rajputja.poster.data.Poster;
import ca.sheridancollege.rajputja.poster.services.PosterService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/posters")
@AllArgsConstructor
public class PosterRestController {

    private final PosterService posterService;

    // GET all posters
    @GetMapping
    public List<Poster> getAllPosters() {
        return posterService.findAll();
    }

    // GET poster by id
    @GetMapping("/{id}")
    public Poster getPosterById(@PathVariable Long id) {
        return posterService.findById(id);
    }

    // POST new poster
    @PostMapping
    public Poster createPoster(@RequestBody Poster poster) {
        return posterService.save(poster);
    }

    // PUT update poster by id
    @PutMapping("/{id}")
    public Poster updatePoster(@PathVariable Long id, @RequestBody Poster poster) {
        return posterService.updateById(id, poster);
    }

    // DELETE poster by id
    @DeleteMapping("/{id}")
    public void deletePoster(@PathVariable Long id) {
        posterService.deleteById(id);
    }
}
package ca.sheridancollege.rajputja.poster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.sheridancollege.rajputja.poster.data.Poster;
import ca.sheridancollege.rajputja.poster.repository.PosterRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PosterServiceImp implements PosterService {

    @Autowired
    private PosterRepository posterRepo;

    @Override
    public List<Poster> findAll() {
        return posterRepo.findAll();
    }

    @Override
    public Poster findById(Long id) {
        Optional<Poster> poster = posterRepo.findById(id);
        return poster.orElse(null);
    }

    @Override
    public Poster save(Poster poster) {
        return posterRepo.save(poster);
    }

    // UPDATE by id

    public Poster updateById(Long id, Poster posterDetails) {
        Optional<Poster> existingPoster = posterRepo.findById(id);

        if (existingPoster.isPresent()) {
            Poster poster = existingPoster.get();

            poster.setName(posterDetails.getName());
            poster.setPrice(posterDetails.getPrice());
            poster.setQuantity(posterDetails.getQuantity());
            poster.setEmployeeName(posterDetails.getEmployeeName());

            return posterRepo.save(poster);
        }

        return null;
    }

    //  DELETE by id
    public void deleteById(Long id) {
        if (posterRepo.existsById(id)) {
            posterRepo.deleteById(id);
        }
    }
}
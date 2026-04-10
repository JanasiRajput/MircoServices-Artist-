package ca.sheridancollege.rajputja.poster.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ca.sheridancollege.rajputja.poster.data.Poster;

@Service
public interface PosterService {

    public List<Poster> findAll();

    public Poster findById(Long id);

    public Poster save(Poster poster);

    public Poster updateById(Long id, Poster poster);

    public void deleteById(Long id);
}
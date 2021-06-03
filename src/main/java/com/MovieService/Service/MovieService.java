package com.MovieService.Service;

import com.MovieService.Repository.MovieRepository;
import com.MovieService.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Optional<Movie> findById(Long id)
    {
        return movieRepository.findById(id);
    }

    public List<Movie> findAll()
    {
        return movieRepository.findAll();
    }

    public Movie save(Movie movie)
    {
        System.out.println("Dodano film");
        return movieRepository.save(movie);
    }

    public void update(Long id, Movie movie) {
        movieRepository.update(id, movie.getName(), movie.getCategory(), movie.getRating(), movie.isAvailable());
    }

    public void delete(Long id) {
        movieRepository.deleteById(id);
    }

    public void setAvailable(Long id)
    {
        movieRepository.setAvailable(id);
    }
}

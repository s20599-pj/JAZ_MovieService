package com.MovieService.Controller;


import com.MovieService.Service.MovieService;
import com.MovieService.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> findAll(){
        return ResponseEntity.ok(movieService.findAll());
    }
    @GetMapping ("movies/{id}")
    public ResponseEntity<Optional<Movie>> findById(@PathVariable Long id)
    {
        Optional<Movie> byId = movieService.findById(id);
        return ResponseEntity.ok(byId);
    }
    @PostMapping ("/movies")
    public ResponseEntity <Movie> addMovie(@RequestBody Movie movie)
    {
        return ResponseEntity.ok(movieService.save(movie));
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity <String> updateMovie(@PathVariable Long id, @RequestBody Movie movie){
        movieService.update(id, movie);
        return ResponseEntity.ok("Zaktualizowano film");
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id)
    {
        movieService.delete(id);
        return ResponseEntity.ok("Usunięto");
    }

    @PutMapping("/movies/setAvailable/{id}")
    public ResponseEntity<String> setAvailableToTrue(@PathVariable Long id)
    {
        movieService.setAvailable(id);
        return ResponseEntity.ok("Produkt jest teraz dostepny!");
    }
}

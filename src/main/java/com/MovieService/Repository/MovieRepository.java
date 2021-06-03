package com.MovieService.Repository;

import com.MovieService.model.Movie;
import com.MovieService.model.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long>{

    @Override
    Optional<Movie> findById(Long id);
    @Override
    List<Movie> findAll();

    @Override
    Movie save(Movie movie);
    @Override
    void deleteById(Long id);

    @Transactional
    @Modifying
    void update(Long id, String name, Category category, int rating, boolean isAvailable);

    @Transactional
    @Modifying
    void setAvailable(Long id);
}

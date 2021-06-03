package com.MovieService.model;

import com.MovieService.model.enums.Category;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Movie.findAll", query = "Select a from Movie a"),
        @NamedQuery(name = "Movie.findAllById", query = "Select a from Movie a where a.id = ?1"),
        @NamedQuery(name = "Movie.delete", query = "delete from Movie a where a.id = ?1"),
        @NamedQuery(name = "Movie.setAvailable", query = "update Movie a set a.isAvailable=1 where a.id=?1"),
        @NamedQuery(name = "Movie.update", query = "update Movie a set a.name = ?2, a.category = ?3, a.rating = ?4, a.isAvailable = ?5 where a.id=?1")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "Movie.save", query = "insert into movie (category, is_available, name, rating) values (?, ?, ?, ?)")
})

public class Movie {
    //region Variables

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    private int rating;
    @Column(columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isAvailable;

    //endregion

    //region Constructors

    public Movie(Long id, String name, Category category)
    {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Movie(String name, Category category, int rating)
    {
        this.name = name;
        this.category = category;
        this.rating = rating;
    }

    public Movie(Long id, String name, Category category, int rating, boolean isAvailable)
    {
        this.id = id;
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.isAvailable = isAvailable;
    }

    public Movie()
    {

    }

    //endregion

    //region Getters and setters

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    //endregion
}

package com.controller;

import com.entity.Movie;
import com.service.MovieService;
import java.util.List;

public class MovieController {
    private MovieService movieService = new MovieService();

    public void addMovie(String title, String category) {
        Movie m = new Movie();
        m.setTitle(title);
        m.setCategory(category);
        movieService.addMovie(m);
        System.out.println("Movie added: " + title);
    }

    public void showAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        for (Movie m : movies) {
            System.out.println("ID: " + m.getId() + " | Title: " + m.getTitle() + " | Category: " + m.getCategory());
        }
    }
    
    public Movie getMovieById(int id) {
        return movieService.getMovieById(id);
    }
}

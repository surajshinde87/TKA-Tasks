package com.service;

import com.dao.MovieDAO;
import com.entity.Movie;
import java.util.List;

public class MovieService {
    private MovieDAO md = new MovieDAO();

    public void addMovie(Movie m) {
        md.addMovie(m);
    }

    public List<Movie> getAllMovies() {
        return md.getAllMovies();
    }
    

    public Movie getMovieById(int id) {
        return md.getMovieById(id);
    }
}

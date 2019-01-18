package pl.coderslab.app.service;

import pl.coderslab.app.model.Movie;

import java.util.List;

public interface MovieService {

    void addMovie(Movie movie);

    void deleteMovie(int movieId);

    void updateMovie(Movie movie);

    List<Movie> getAllMovies();

    Movie getMovieById(int movieId);
}

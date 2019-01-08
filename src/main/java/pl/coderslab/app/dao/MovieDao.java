package pl.coderslab.app.dao;

import pl.coderslab.app.model.Movie;

import java.util.List;

public interface MovieDao {

    void addMovie(Movie movie);

    void deleteMovie(int movieId);

    void updateMovie(Movie movie);

    List<Movie> getAllMovies();

    Movie getMovieById(int movieId);

}
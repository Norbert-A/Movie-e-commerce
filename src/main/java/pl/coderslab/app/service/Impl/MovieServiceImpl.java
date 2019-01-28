package pl.coderslab.app.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.model.Movie;
import pl.coderslab.app.repository.MovieRepository;
import pl.coderslab.app.service.MovieService;

import java.util.List;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(int movieId) {
        movieRepository.deleteById(movieId);
    }

    @Override
    public void updateMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    @Override
    public Movie getMovieById(int movieId) {
        return movieRepository.getOne(movieId);
    }

    @Override
    public List<Movie> getAllMoviesAdmin() {
        return movieRepository.getAllMoviesAdmin();
    }
}

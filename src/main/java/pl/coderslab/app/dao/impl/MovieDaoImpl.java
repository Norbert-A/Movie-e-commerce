package pl.coderslab.app.dao.impl;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.dao.MovieDao;
import pl.coderslab.app.model.Movie;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class MovieDaoImpl implements MovieDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addMovie(Movie movie) {
        entityManager.persist(movie);
    }

    @Override
    public void deleteMovie(int movieId) {
        Movie movie = getMovieById(movieId);
        entityManager.remove(movie);
    }

    @Override
    public void updateMovie(Movie movie) {
        entityManager.merge(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        Query query = entityManager.createQuery("select m from Movie m");
        return query.getResultList();
    }

    @Override
    public Movie getMovieById(int movieId) {
        return entityManager.find(Movie.class, movieId);
    }
}



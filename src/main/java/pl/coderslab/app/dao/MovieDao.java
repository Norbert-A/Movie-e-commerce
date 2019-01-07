package pl.coderslab.app.dao;

import pl.coderslab.app.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieDao {

    private List<Movie> movieList;

    public List<Movie> getMovieList() {
        Movie braveheart = new Movie();

        braveheart.setMovieTitle("Braveheart");
        braveheart.setMovieCategory("Thriller");
        braveheart.setMovieDescription("Warrior");
        braveheart.setMoviePrice(40);
        braveheart.setMovieStatus("available");
        braveheart.setMovieRating(8);

        movieList = new ArrayList<Movie>();
        movieList.add(braveheart);

        return movieList;

    }
}

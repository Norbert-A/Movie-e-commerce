package pl.coderslab.app.dao;

import pl.coderslab.app.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieDao {

    private List<Movie> movieList;

    public List<Movie> getMovieList() {
        Movie aquaman = new Movie();

        aquaman.setMovieTitle("Aquaman");
        aquaman.setMovieCategory("Action");
        aquaman.setMovieDescription("Water vs Earth");
        aquaman.setMovieTrailerId("WDkg3h8PCVU");
        aquaman.setMoviePrice(19.99);
        aquaman.setMovieStatus("available");
        aquaman.setMovieRating(8.5);

        movieList = new ArrayList<Movie>();
        movieList.add(aquaman);

        return movieList;

    }
}

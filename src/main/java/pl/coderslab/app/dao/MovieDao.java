package pl.coderslab.app.dao;

import pl.coderslab.app.model.Movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieDao {

    private List<Movie> movieList;

    public List<Movie> getMovieList() {
        Movie aquaman = new Movie();

        aquaman.setMovieId(10);
        aquaman.setMovieTitle("Aquaman");
        aquaman.setMovieCategory("Action");
        aquaman.setMovieDescription("Arthur Curry learns that he is the heir to the underwater kingdom of Atlantis, and must step forward to lead his people and be a hero to the world.");
        aquaman.setMovieStars("Jason Momoa, Amber Heard, Willem Dafoe");
        aquaman.setMovieDirector("James Wan");
        aquaman.setMovieDuration(143);
        aquaman.setMovieTrailerId("WDkg3h8PCVU");
        aquaman.setMoviePrice(19.99);
        aquaman.setMovieStatus("available");
        aquaman.setMovieRating(8.5);

        movieList = new ArrayList<Movie>();
        movieList.add(aquaman);

        return movieList;
    }

    public Movie getMovieById(int movieId) throws IOException{
        for(Movie movie: getMovieList()){
            if(movie.getMovieId()==movieId){
                return movie;
            }
        }
        throw new IOException("Movie not found");

    }
}

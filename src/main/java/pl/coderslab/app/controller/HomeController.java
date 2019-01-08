package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.dao.MovieDao;
import pl.coderslab.app.model.Movie;

import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {

    private MovieDao movieDao = new MovieDao();

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/movieList")
    public String getMovieList(Model model) {
        List<Movie> movies = movieDao.getMovieList();
        model.addAttribute("movies", movies);

        return "movieList";
    }

    @RequestMapping("/movieList/movieDetails/{movieId}")
    public String getMovieDetails(@PathVariable int movieId, Model model) throws IOException {
        Movie movie = movieDao.getMovieById(movieId);
        model.addAttribute(movie);
        return "movieDetails";
    }

}

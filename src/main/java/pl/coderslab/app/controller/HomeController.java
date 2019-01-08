package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.dao.MovieDao;
import pl.coderslab.app.model.Movie;

import java.util.List;

@Controller
public class HomeController {

    private MovieDao movieDao = new MovieDao();

    @RequestMapping("/")
    public String home() {
        return "trailerCode";
    }

    @RequestMapping("/movieList")
    public String getMovies(Model model) {
        List<Movie> movies = movieDao.getMovieList();
        model.addAttribute("movies", movies);

        return "movieList";
    }

}

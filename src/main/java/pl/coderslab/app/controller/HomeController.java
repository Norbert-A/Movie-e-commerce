package pl.coderslab.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.dao.MovieDao;
import pl.coderslab.app.model.Movie;

import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private MovieDao movieDao;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/admin")
    public String administration(){
        return "admin";
    }

    @RequestMapping("/admin/movieInventory")
    public String movieInventory(Model model){
        List<Movie> movies = movieDao.getAllMovies();
        model.addAttribute("movies", movies);

        return "movieInventory";
    }

    @GetMapping("/admin/movieInventory/addMovie")
    public String addMovie(Model model){
        Movie movie = new Movie();
        model.addAttribute("movie", movie);

        return "addMovie";
    }

    @RequestMapping("/movieList")
    public String getMovieList(Model model) {
        List<Movie> movies = movieDao.getAllMovies();
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

package pl.coderslab.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.app.model.Movie;
import pl.coderslab.app.repository.MovieRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class AdminController {

    private Path path;

    @Autowired
    private MovieRepository  movieRepository;

    @RequestMapping("/admin")
    public String administration() {
        return "admin";
    }

    @RequestMapping("/admin/movieInventory")
    public String movieInventory(Model model) {
        List<Movie> movies = movieRepository.getAllMovies();
        model.addAttribute("movies", movies);

        return "movieInventory";
    }

    @GetMapping("/admin/movieInventory/addMovie")
    public String addMovie(Model model) {
        Movie movie = new Movie();
        model.addAttribute("movie", movie);

        return "addMovie";
    }

    @GetMapping("/admin/movieInventory/updateMovie/{movieId}")
    public String updateMovie(@PathVariable int movieId, Model model) {
        Movie movie = movieRepository.getOne(movieId);
        model.addAttribute(movie);

        return "updateMovie";
    }

    @PostMapping("/admin/movieInventory/updateMovie/{movieId}")
    public String updateMoviePost(@Valid @PathVariable int movieId, @ModelAttribute("movie") Movie movie, BindingResult result,
                                  HttpServletRequest request) {

        if(result.hasErrors()){
            return "updateMovie";
        }

        String rootDirectory = request.getSession().getServletContext().getRealPath("WEB-INF/resources/images/");
        path = Paths.get(rootDirectory + movieId + ".jpg");

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        MultipartFile movieImage = movie.getMovieImage();

        if (movieImage != null && !movieImage.isEmpty()) {
            try {
                movieImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Image update failed");
            }
        }

        movieRepository.save(movie);

        return "redirect:/admin/movieInventory";
    }


    @PostMapping("/admin/movieInventory/addMovie")
    public String addMoviePost(@Valid @ModelAttribute("movie") Movie movie, BindingResult result, HttpServletRequest request) {

        if(result.hasErrors()){
            return "addMovie";
        }

        movieRepository.save(movie);

        MultipartFile movieImage = movie.getMovieImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/WEB-INF/resources/images/");
        path = Paths.get(rootDirectory + movie.getMovieId()+".jpg");

        if (movieImage != null && !movieImage.isEmpty()) {
            try {
                movieImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Image saving failed");
            }
        }

        return "redirect:/admin/movieInventory";
    }

    @RequestMapping("/admin/movieInventory/deleteMovie/{movieId}")
    public String deleteMovie(@PathVariable int movieId, Model model, HttpServletRequest request) throws IOException {
        movieRepository.deleteById(movieId);

        String rootDirectory = request.getSession().getServletContext().getRealPath("WEB-INF/resources/images/");
        path = Paths.get(rootDirectory + movieId + ".jpg");

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return "redirect:/admin/movieInventory";
    }
}
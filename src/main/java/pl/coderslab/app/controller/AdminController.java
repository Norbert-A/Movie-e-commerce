package pl.coderslab.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.app.model.*;
import pl.coderslab.app.repository.MovieRepository;
import pl.coderslab.app.repository.SavedItemsRepository;
import pl.coderslab.app.service.*;

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
    private MovieService movieService;

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserOrderService userOrderService;

    @Autowired
    SavedItemsRepository savedItemsRepository;


    @RequestMapping("/admin")
    public String administration() {
        return "admin";
    }

    @RequestMapping("/admin/movieInventory")
    public String movieInventory(Model model) {
        List<Movie> movies = movieService.getAllMoviesAdmin();
        model.addAttribute("movies", movies);

        return "movieInventory";
    }


    @GetMapping("/admin/movieInventory/updateMovie/{movieId}")
    public String updateMovie(@PathVariable int movieId, Model model) {
        Movie movie = movieService.getMovieById(movieId);
        model.addAttribute(movie);

        return "updateMovie";
    }

    @PostMapping("/admin/movieInventory/updateMovie/{movieId}")
    public String updateMoviePost(@Valid @PathVariable int movieId, @ModelAttribute("movie") Movie movie, BindingResult result,
                                  HttpServletRequest request) {

        if (result.hasErrors()) {
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

        movieService.updateMovie(movie);

        return "redirect:/admin/movieInventory";
    }

    @GetMapping("/admin/movieInventory/addMovie")
    public String addMovie(Model model) {
        Movie movie = new Movie();
        model.addAttribute("movie", movie);

        return "addMovie";
    }

    @PostMapping("/admin/movieInventory/addMovie")
    public String addMoviePost(@Valid @ModelAttribute("movie") Movie movie, BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()) {
            return "addMovie";
        }

        movieService.addMovie(movie);

        MultipartFile movieImage = movie.getMovieImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/WEB-INF/resources/images/");
        path = Paths.get(rootDirectory + movie.getMovieId() + ".jpg");

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
    public String deleteMovie(@PathVariable int movieId, HttpServletRequest request) throws IOException {

        String rootDirectory = request.getSession().getServletContext().getRealPath("WEB-INF/resources/images/");
        path = Paths.get(rootDirectory + movieId + ".jpg");

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        movieService.deleteMovie(movieId);

        return "redirect:/admin/movieInventory";
    }

    @RequestMapping("/admin/users")
    public String users(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "users";
    }

    @RequestMapping("/admin/users/deleteUser/{userId}")
    public String deleteMovie(@PathVariable int userId, Model model) {
        List<UserOrder> orders = userService.findUser(userId).getUserOrders();
        if(orders.size() > 0) {
            model.addAttribute("error", "Active User Order!");
            List<User> users = userService.getAllUsers();
            model.addAttribute("users", users);
            return "users";
        }
        userService.deleteUser(userId);

        return "redirect:/admin/users";
    }

    @RequestMapping("/admin/orders")
    public String adminOrders(Model model) {
        List<UserOrder> orders = userOrderService.getAllOrders();
        model.addAttribute("orders", orders);

        return "adminOrders";
    }

    @RequestMapping("/admin/orders/details/{orderId}")
    public String orderDetails(@PathVariable int orderId, Model model){
        UserOrder order = userOrderService.getOrderById(orderId);
        model.addAttribute("order", order);

        return "orderDetails";
    }

    @RequestMapping("/admin/orders/removeOrder/{orderId}/{cartId}")
    public String deleteOrder(@PathVariable int orderId, @PathVariable int cartId) {

        userOrderService.deleteOrder(orderId);

        Cart cart = cartService.getCartById(cartId);

        List<SavedItems> savedItems = cart.getSavedItems();
        savedItemsRepository.deleteAll(savedItems);



        return "redirect:/admin/orders";
    }
}
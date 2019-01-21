package pl.coderslab.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.model.Cart;
import pl.coderslab.app.model.CartItem;
import pl.coderslab.app.model.Movie;
import pl.coderslab.app.repository.CartItemRepository;
import pl.coderslab.app.service.CartItemService;
import pl.coderslab.app.service.CartService;
import pl.coderslab.app.service.MovieService;
import pl.coderslab.app.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/rest/cart")
public class CartRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CartItemRepository cartItemRepository;

    @RequestMapping("/{cartId}")
    public @ResponseBody
    Cart getCartById (@PathVariable int cartId) {
        return cartService.getCartById(cartId);
    }


    @PutMapping(value = "/add/{movieId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem (@PathVariable (value = "movieId") int movieId, @AuthenticationPrincipal User user) {

        Cart cart = userService.findUserByEmail(user.getUsername()).getCart();
        Movie movie = movieService.getMovieById(movieId);
        List<CartItem> cartItems = cart.getCartItems();

        for (int i = 0; i <cartItems.size(); i++) {

            if(movie.getMovieId() == cartItems.get(i).getMovie().getMovieId()){

                CartItem cartItem = cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity()+1);
                cartItem.setTotalPrice(movie.getMoviePrice() * cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);

                return;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setMovie(movie);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(movie.getMoviePrice());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
    }

    @PutMapping(value = "/remove/{movieId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem (@PathVariable (value="movieId") int movieId) {
        CartItem cartItem = cartItemService.getCartItemByMovieId(movieId);
        cartItemService.deleteCartItem(cartItem);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public void handleClientErrors (Exception e) {}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public void handleServerErrors (Exception e) {}

}

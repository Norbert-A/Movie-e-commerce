package pl.coderslab.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.model.*;
import pl.coderslab.app.repository.SavedItemsRepository;
import pl.coderslab.app.service.*;

import java.util.List;


@RestController
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
    private UserOrderService userOrderService;

    @Autowired
    private SavedItemsRepository savedItemsRepository;

    @RequestMapping("/{cartId}")
    public Cart getCartById (@PathVariable int cartId) {
        return cartService.getCartById(cartId);
    }

    @PutMapping("/remove/{movieId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem (@PathVariable int movieId) {
        CartItem cartItem = cartItemService.getCartItemByMovieId(movieId);
        cartItemService.deleteCartItemById(cartItem.getCartItemId());
//        cartItemService.deleteCartItem(cartItem);
        SavedItems savedItem = savedItemsRepository.getSavedItemByMovieId(movieId);
        savedItemsRepository.delete(savedItem);
    }

    @PutMapping("/add/{movieId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem (@PathVariable int movieId, @AuthenticationPrincipal User user) {

        Cart cart = userService.findUserByEmail(user.getUsername()).getCart();
        Movie movie = movieService.getMovieById(movieId);
        List<CartItem> cartItems = cart.getCartItems();

        List<SavedItems> savedItems = cart.getSavedItems();

        for (int i = 0; i <savedItems.size(); i++) {

            if(movie.getMovieId() == savedItems.get(i).getMovie().getMovieId()){

                SavedItems savedItem = savedItems.get(i);
                savedItem.setQuantity(savedItem.getQuantity()+1);
                savedItem.setTotalPrice(movie.getMoviePrice() * savedItem.getQuantity());
                savedItem.setGrandTotal(userOrderService.getOrderGrandTotal(cart.getCartId()));
                savedItemsRepository.save(savedItem);

            }
        }

        for (int i = 0; i <cartItems.size(); i++) {

            if(movie.getMovieId() == cartItems.get(i).getMovie().getMovieId()){

                CartItem cartItem = cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity()+1);
                cartItem.setTotalPrice(movie.getMoviePrice() * cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);

                return;
            }
        }

        SavedItems savedItem = new SavedItems();
        savedItem.setMovie(movie);
        savedItem.setQuantity(1);
        savedItem.setTotalPrice(movie.getMoviePrice());
        savedItem.setCart(cart);
        savedItem.setGrandTotal(userOrderService.getOrderGrandTotal(cart.getCartId()));
        savedItemsRepository.save(savedItem);

        CartItem cartItem = new CartItem();
        cartItem.setMovie(movie);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(movie.getMoviePrice());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public void handleClientErrors (Exception e) {}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public void handleServerErrors (Exception e) {}

}

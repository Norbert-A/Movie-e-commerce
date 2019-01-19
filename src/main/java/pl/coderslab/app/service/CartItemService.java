package pl.coderslab.app.service;

import pl.coderslab.app.model.Cart;
import pl.coderslab.app.model.CartItem;

public interface CartItemService {

    void addCartItem(CartItem cartItem);

    void deleteCartItem(CartItem cartItem);

    void deleteAllCartItems(Cart cart);

    CartItem getCartItemByMovieId (int movieId);
}

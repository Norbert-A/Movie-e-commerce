package pl.coderslab.app.service;

import pl.coderslab.app.model.CartItem;

public interface CartItemService {

    void addCartItem(CartItem cartItem);

    void deleteCartItem(CartItem cartItem);

    void deleteCartItemById(int cartItemId);

    CartItem getCartItemByMovieId (int movieId);
}

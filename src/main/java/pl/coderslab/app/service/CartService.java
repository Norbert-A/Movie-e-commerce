package pl.coderslab.app.service;

import pl.coderslab.app.model.Cart;

import java.io.IOException;

public interface CartService {

    Cart getCartById (int cartId);

    Cart validateCart(int cartId) throws IOException;

    void updateCart(Cart cart);
}

package pl.coderslab.app.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.model.Cart;
import pl.coderslab.app.model.CartItem;
import pl.coderslab.app.repository.CartItemRepository;
import pl.coderslab.app.service.CartItemService;

import java.util.List;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;


    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteCartItem(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
    }


    @Override
    public void deleteAllCartItems(Cart cart) {
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem cartItem : cartItems) {
            deleteCartItem(cartItem);
        }
    }

    @Override
    public void deleteCartItemById(int cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    @Override
    public CartItem getCartItemByMovieId(int movieId) {
        return cartItemRepository.getCartItemByMovieId(movieId);
    }
}

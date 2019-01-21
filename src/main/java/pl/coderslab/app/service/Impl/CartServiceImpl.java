package pl.coderslab.app.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.app.model.Cart;
import pl.coderslab.app.repository.CartRepository;
import pl.coderslab.app.service.CartService;
import pl.coderslab.app.service.UserOrderService;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserOrderService orderService;

    @Override
    public Cart getCartById(int cartId) {
        return cartRepository.findById(cartId);
    }

}

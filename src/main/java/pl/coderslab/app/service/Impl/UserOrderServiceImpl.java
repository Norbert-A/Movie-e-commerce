package pl.coderslab.app.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.model.Cart;
import pl.coderslab.app.model.CartItem;
import pl.coderslab.app.model.UserOrder;
import pl.coderslab.app.repository.UserOrderRepository;
import pl.coderslab.app.service.CartService;
import pl.coderslab.app.service.UserOrderService;

import java.util.List;

@Service
@Transactional
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserOrderRepository orderRepository;

    public void addOrder(UserOrder order) {
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(int orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public void updateOrder(UserOrder order) {
        orderRepository.save(order);
    }

    public double getOrderGrandTotal(int cartId) {

        double grandTotal = 0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems) {
            grandTotal += item.getTotalPrice();
        }

        return grandTotal;
    }
}

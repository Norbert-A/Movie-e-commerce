package pl.coderslab.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.model.Cart;
import pl.coderslab.app.model.CartItem;
import pl.coderslab.app.model.User;
import pl.coderslab.app.model.UserOrder;
import pl.coderslab.app.service.CartItemService;
import pl.coderslab.app.service.CartService;
import pl.coderslab.app.service.Impl.NotificationService;
import pl.coderslab.app.service.UserOrderService;

import java.util.Date;
import java.util.List;

@Controller
public class UserOrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserOrderService userOrderService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private NotificationService notificationService;

    @RequestMapping("/order/{cartId}")
    public String getUserOrder(@PathVariable int cartId, Model model) {

        UserOrder order = new UserOrder();
        Cart cart = cartService.getCartById(cartId);
        cart.setGrandTotal(userOrderService.getOrderGrandTotal(cartId));
        order.setCart(cart);
        Date dateNow = new Date();
        order.setOrderDate(dateNow);

        User user = cart.getUser();
        order.setUser(user);
        order.setAddress(user.getAddress());

        model.addAttribute("order", order);

        return "order";
    }

    @RequestMapping("/order/confirm/{cartId}")
    public String confirmOrder(@PathVariable int cartId) {


        UserOrder order = new UserOrder();
        Date dateNow = new Date();
        order.setOrderDate(dateNow);
        Cart cart = cartService.getCartById(cartId);
        cart.setGrandTotal(userOrderService.getOrderGrandTotal(cartId));

        order.setCart(cart);

        User user = cart.getUser();
        order.setUser(user);
        order.setAddress(user.getAddress());

        userOrderService.addOrder(order);

//        notificationService.sendOrderReceipt(user, order);

        cartItemService.deleteAllCartItems(cart);

        return "thankYou";
    }

}
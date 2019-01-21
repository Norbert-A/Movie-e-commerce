package pl.coderslab.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.service.UserService;

@Controller
public class CartController {

    @Autowired
    private UserService userService;

    @RequestMapping("/cart")
    public String getCart(@AuthenticationPrincipal User user, Model model){

        int cartId = userService.findUserByEmail(user.getUsername()).getCart().getCartId();

        model.addAttribute("cartId", cartId);

        return "cart";
    }
}

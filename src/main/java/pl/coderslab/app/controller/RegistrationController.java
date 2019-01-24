package pl.coderslab.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.model.Address;
import pl.coderslab.app.model.User;
import pl.coderslab.app.service.Impl.NotificationService;
import pl.coderslab.app.service.UserService;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    @RequestMapping("/registration")
    public String registrationGet(Model model){
        User user = new User();
        Address address = new Address();
        user.setAddress(address);

        model.addAttribute("user", user);

        return "registration";
    }

    @PostMapping("/registration")
    public String registrationPOST(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {

        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            model.addAttribute("emailMsg", "There is already a user registered with the email provided");
            return "registration";
        }
        if (bindingResult.hasErrors()) {
            return "registration";
        } else {
            userService.addUser(user);
            notificationService.sendRegistrationNotification(user);

        }
        return "login";
    }

}

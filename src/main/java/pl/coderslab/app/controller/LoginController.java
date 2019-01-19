package pl.coderslab.app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required = false) String error, @RequestParam(value="email",
            required = false) String email, Model model) {

        if (error!=null) {
            model.addAttribute("error", "Invalid Credentials!");

            return "login";
        }

        return "login";
    }

}
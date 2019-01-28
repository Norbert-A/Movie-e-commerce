package pl.coderslab.app.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.coderslab.app.model.Cart;
import pl.coderslab.app.model.CartItem;
import pl.coderslab.app.model.User;
import pl.coderslab.app.model.UserOrder;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class NotificationService {

    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService (JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendRegistrationNotification(User user) {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom("movielandia@mail.com");
        mail.setSubject("Welcome to MovieLandia!");
        mail.setText("Thank you for your registration! We hope you'll find what you're looking for :)");

        javaMailSender.send(mail);
    }

    public void sendOrderReceipt (User user, UserOrder order) {


        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom("movielandia@mail.com");
        mail.setSubject("Your MovieLandia Order");
        mail.setText("Thank you " + user.getName() + " for your order nr: " + order.getOrderId() + "\n \n Have a nice day :)");

        javaMailSender.send(mail);

    }
}

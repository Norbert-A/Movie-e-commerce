package pl.coderslab.app.service;

import pl.coderslab.app.model.Order;

public interface OrderService {

    void addOrder(Order order);

    void deleteOrder(int orderId);

    void updateOrder(Order order);

    double getOrderGrandTotal(int cartId);


}

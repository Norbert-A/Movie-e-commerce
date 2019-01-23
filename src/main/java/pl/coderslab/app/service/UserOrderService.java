package pl.coderslab.app.service;

import pl.coderslab.app.model.UserOrder;

import java.util.List;

public interface UserOrderService {

    void addOrder(UserOrder order);

    void deleteOrder(int orderId);

    void updateOrder(UserOrder order);

    double getOrderGrandTotal(int cartId);

    List<UserOrder> getAllOrders();

    UserOrder getOrderById (int orderId);

}

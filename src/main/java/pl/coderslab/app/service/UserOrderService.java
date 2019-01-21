package pl.coderslab.app.service;

import pl.coderslab.app.model.UserOrder;

public interface UserOrderService {

    void addOrder(UserOrder order);

    void deleteOrder(int orderId);

    void updateOrder(UserOrder order);

    double getOrderGrandTotal(int cartId);


}

package pl.coderslab.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.app.model.UserOrder;

public interface UserOrderRepository extends JpaRepository<UserOrder, Integer> {


    @Query(value = "select * from user_order where order_id = ?", nativeQuery = true)
    UserOrder findOrderByOrderId(int orderId);
}

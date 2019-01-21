package pl.coderslab.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.app.model.UserOrder;

public interface UserOrderRepository extends JpaRepository<UserOrder, Integer> {
}

package pl.coderslab.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.app.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}

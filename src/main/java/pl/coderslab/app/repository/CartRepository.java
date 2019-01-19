package pl.coderslab.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.app.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}

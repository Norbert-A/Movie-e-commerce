package pl.coderslab.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.app.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query(value = "select * from cart where cart_id = ?", nativeQuery = true)
    Cart findById(int cartId);
}


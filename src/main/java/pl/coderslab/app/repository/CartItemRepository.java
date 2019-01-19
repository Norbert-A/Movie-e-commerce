package pl.coderslab.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.app.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

    @Query(value = "SELECT * FROM cartItem WHERE movieId = ?1", nativeQuery = true)
    CartItem getCartItemByMovieId(int movieId);
}

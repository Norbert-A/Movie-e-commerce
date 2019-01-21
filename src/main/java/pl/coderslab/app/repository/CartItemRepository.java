package pl.coderslab.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.app.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

    @Query(value = "SELECT * FROM cart_item WHERE movie_id = ?", nativeQuery = true)
    CartItem getCartItemByMovieId(int movieId);

    @Query(value = "DELETE from cart_item where cart_item_id = ?", nativeQuery = true)
    CartItem deleteCartItemById(int cartItemId);
}

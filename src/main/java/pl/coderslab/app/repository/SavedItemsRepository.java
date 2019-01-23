package pl.coderslab.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.app.model.SavedItems;

public interface SavedItemsRepository extends JpaRepository<SavedItems, Integer> {

    @Query(value = "SELECT * FROM saved_items WHERE movie_id = ?", nativeQuery = true)
    SavedItems getSavedItemByMovieId(int movieId);
}

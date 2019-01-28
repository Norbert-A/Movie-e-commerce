package pl.coderslab.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieId;
    @NotEmpty(message = "Must have a title")
    private String movieTitle;
    @Transient
    private MultipartFile movieImage;
    private String movieCategory;
    private String movieDescription;
    private int movieDuration;
    private String movieDirector;
    private String movieStars;
    private String movieTrailerId;
    @Min(value = 1, message = "Must have a price")
    private double moviePrice;
    private boolean movieStatus;
    private String movieRating;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CartItem> cartItemList;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<SavedItems> savedItemsList;

    public List<SavedItems> getSavedItemsList() {
        return savedItemsList;
    }

    public void setSavedItemsList(List<SavedItems> savedItemsList) {
        this.savedItemsList = savedItemsList;
    }

    public MultipartFile getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(MultipartFile movieImage) {
        this.movieImage = movieImage;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public int getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(int movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String getMovieStars() {
        return movieStars;
    }

    public void setMovieStars(String movieStars) {
        this.movieStars = movieStars;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieTrailerId() {
        return movieTrailerId;
    }

    public void setMovieTrailerId(String movieTrailerId) {
        this.movieTrailerId = movieTrailerId;
    }

    public double getMoviePrice() {
        return moviePrice;
    }

    public void setMoviePrice(double moviePrice) {
        this.moviePrice = moviePrice;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(String movieCategory) {
        this.movieCategory = movieCategory;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public boolean isMovieStatus() {
        return movieStatus;
    }

    public void setMovieStatus(boolean movieStatus) {
        this.movieStatus = movieStatus;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }
}

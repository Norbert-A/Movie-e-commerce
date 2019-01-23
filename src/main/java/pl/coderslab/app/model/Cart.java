package pl.coderslab.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Cart implements Serializable {

    private static final long serialVersionUID = -6714185688931429721L;

    @Id
    @GeneratedValue
    private int cartId;

    @OneToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.REMOVE)
    private List<CartItem> cartItems;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.REMOVE)
    private List<SavedItems> savedItems;

    private double grandTotal;

    public List<SavedItems> getSavedItems() {
        return savedItems;
    }

    public void setSavedItems(List<SavedItems> savedItems) {
        this.savedItems = savedItems;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

}
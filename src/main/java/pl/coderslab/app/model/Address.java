package pl.coderslab.app.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Address implements Serializable {


    private static final long serialVersionUID = 3144244634698356895L;

    @Id
    @GeneratedValue
    private int addressId;
    private String address;
    private String city;
    private String country;

    @OneToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @OneToOne(cascade= CascadeType.ALL)
    private User user;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
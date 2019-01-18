package pl.coderslab.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
public class User implements Serializable {

    public static final long serialVersionUID = -8720126006597212481L;

    @Id
    @GeneratedValue
    private int id;

    @NotEmpty(message="Can't be empty")
    private String name;

    @NotEmpty(message="Can't be empty")
    @Email(message="Must be email-format")
    private String email;
    private String phone;

    @NotEmpty(message="Can't be empty")
    @Length(min = 5, message="Most be longer than 5")
    private String password;

    private boolean active;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="user_role", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
    private Set<Role> roles;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="addressId")
    private Address address;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getUserId() {
        return id;
    }

    public void setUserId(int userId) {
        this.id = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
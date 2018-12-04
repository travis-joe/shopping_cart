package com.xiedaimala.shopping_cart.user.model;

import com.xiedaimala.shopping_cart.cartItem.model.CartItem;
import com.xiedaimala.shopping_cart.order.model.Order;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name",unique = true)
    private String name;

    @Column(name="password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "user")
    private Set<CartItem> cartItems;

//    @OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER,
//            mappedBy = "user")
//    private Set<Order> orders;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

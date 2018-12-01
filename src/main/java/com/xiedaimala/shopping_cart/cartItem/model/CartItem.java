package com.xiedaimala.shopping_cart.cartItem.model;

import com.xiedaimala.shopping_cart.product.model.Product;
import com.xiedaimala.shopping_cart.user.model.User;

import javax.persistence.*;

@Entity
@Table(name="cart_item")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "quantity")
    private long quantity;

    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "user_id")
    private User user;

    public CartItem() {
    }

    public CartItem(long quantity, Product product, User user) {
        this.quantity = quantity;
        this.product = product;
        this.user = user;
    }

    public long getId() {
        return id;
    }


    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public User getUser() {
        return user;
    }
}

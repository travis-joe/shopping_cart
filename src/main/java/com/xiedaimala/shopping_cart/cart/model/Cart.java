package com.xiedaimala.shopping_cart.cart.model;

import com.xiedaimala.shopping_cart.product.model.Product;

public class Cart {
    private long id;
    private String name;
    private Product products;

    public Cart(long id, String name, Product products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }
}

package com.xiedaimala.shopping_cart.cart.model;

import java.util.List;

public class ListCartResponse {
    private List<Cart> carts;

    public ListCartResponse(List<Cart> carts) {
        this.carts = carts;
    }

    public ListCartResponse() {
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
}

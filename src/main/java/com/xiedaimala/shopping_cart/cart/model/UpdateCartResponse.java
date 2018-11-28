package com.xiedaimala.shopping_cart.cart.model;

public class UpdateCartResponse {
    private Cart cart;

    public UpdateCartResponse(Cart cart) {
        this.cart = cart;
    }

    public UpdateCartResponse() {
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}

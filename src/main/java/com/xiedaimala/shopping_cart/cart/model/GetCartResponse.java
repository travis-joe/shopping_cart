package com.xiedaimala.shopping_cart.cart.model;

public class GetCartResponse {

    private Cart cart;

    public GetCartResponse(Cart cart) {
        this.cart = cart;
    }

    public GetCartResponse() {
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}

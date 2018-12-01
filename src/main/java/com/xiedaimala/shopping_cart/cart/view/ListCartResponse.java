package com.xiedaimala.shopping_cart.cart.view;

import com.xiedaimala.shopping_cart.cart.model.CartItem;

import java.util.List;

public class ListCartResponse {
    private List<CartItem> cartItems;

    public ListCartResponse(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public ListCartResponse() {
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}

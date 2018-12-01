package com.xiedaimala.shopping_cart.cartItem.view;

import com.xiedaimala.shopping_cart.cartItem.model.CartItem;

import java.util.List;

public class ListCartItemResponse {
    private List<CartItem> cartItems;

    public ListCartItemResponse(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public ListCartItemResponse() {
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}

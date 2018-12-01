package com.xiedaimala.shopping_cart.cart.view;

import com.xiedaimala.shopping_cart.cart.model.CartItem;

public class UpdateCartResponse {
    private CartItem cartItem;

    public UpdateCartResponse(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    public UpdateCartResponse() {
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }
}

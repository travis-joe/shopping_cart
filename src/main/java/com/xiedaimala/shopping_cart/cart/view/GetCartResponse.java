package com.xiedaimala.shopping_cart.cart.view;

import com.xiedaimala.shopping_cart.cart.model.CartItem;

public class GetCartResponse {

    private CartItem cartItem;

    public GetCartResponse(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    public GetCartResponse() {
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }
}

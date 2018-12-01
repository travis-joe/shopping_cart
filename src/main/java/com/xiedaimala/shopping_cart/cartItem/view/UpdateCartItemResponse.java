package com.xiedaimala.shopping_cart.cartItem.view;

import com.xiedaimala.shopping_cart.cartItem.model.CartItem;

public class UpdateCartItemResponse {
    private CartItem cartItem;

    public UpdateCartItemResponse(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    public UpdateCartItemResponse() {
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }
}

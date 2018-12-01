package com.xiedaimala.shopping_cart.cartItem.view;

import com.xiedaimala.shopping_cart.cartItem.model.CartItem;

public class GetCartItemResponse {

    private CartItem cartItem;

    public GetCartItemResponse(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    public GetCartItemResponse() {
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }
}

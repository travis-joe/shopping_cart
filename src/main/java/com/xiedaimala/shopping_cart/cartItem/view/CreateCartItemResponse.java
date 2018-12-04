package com.xiedaimala.shopping_cart.cartItem.view;

import com.xiedaimala.shopping_cart.cartItem.model.CartItem;

public class CreateCartItemResponse {

    CartItem item;

    public CreateCartItemResponse() {
    }

    public CreateCartItemResponse(CartItem item) {
        this.item = item;
    }

    public CartItem getItem() {
        return item;
    }

    public void setItem(CartItem item) {
        this.item = item;
    }
}

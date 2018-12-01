package com.xiedaimala.shopping_cart.cartItem.view;

public class CreateCartItemRequest {
    private long user_id;
    private long product_id;
    private long quantity;

    public CreateCartItemRequest() {
    }

    public CreateCartItemRequest(long user_id, long product_id, long quantity) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}

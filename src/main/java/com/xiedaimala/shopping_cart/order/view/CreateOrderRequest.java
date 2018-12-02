package com.xiedaimala.shopping_cart.order.view;

import com.xiedaimala.shopping_cart.product.model.Product;
import com.xiedaimala.shopping_cart.user.model.User;

public class CreateOrderRequest {
    private long userId;
    private long productId;
    private long quantity;
    private String status;
    private String address;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long product) {
        this.productId = product;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CreateOrderRequest() {
    }

    public CreateOrderRequest(long userId, long product, Integer quantity, String status, String address) {
        this.userId = userId;
        this.productId = product;
        this.quantity = quantity;
        this.status = status;
        this.address = address;
    }
}

package com.xiedaimala.shopping_cart.cartItem.view;

import java.util.List;

public class UpdateCartItemRequest {
    private String name;
    private List<String> productIds;

    public UpdateCartItemRequest(String name, List<String> productIds) {
        this.name = name;
        this.productIds = productIds;
    }

    public UpdateCartItemRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }
}

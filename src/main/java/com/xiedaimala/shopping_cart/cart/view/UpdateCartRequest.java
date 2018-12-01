package com.xiedaimala.shopping_cart.cart.view;

import java.util.List;

public class UpdateCartRequest {
    private String name;
    private List<String> productIds;

    public UpdateCartRequest(String name, List<String> productIds) {
        this.name = name;
        this.productIds = productIds;
    }

    public UpdateCartRequest() {
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

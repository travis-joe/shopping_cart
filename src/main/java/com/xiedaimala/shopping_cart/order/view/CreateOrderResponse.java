package com.xiedaimala.shopping_cart.order.view;

import com.xiedaimala.shopping_cart.order.model.Order;

public class CreateOrderResponse {
    private Order order;

    public CreateOrderResponse(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public CreateOrderResponse() {
    }
}

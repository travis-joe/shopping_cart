package com.xiedaimala.shopping_cart.order.view;

import com.xiedaimala.shopping_cart.order.model.Order;

public class GetOrderResponse {
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public GetOrderResponse(Order order) {
        this.order = order;
    }

    public GetOrderResponse() {
    }
}

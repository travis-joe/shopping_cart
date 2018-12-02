package com.xiedaimala.shopping_cart.order.view;

import com.xiedaimala.shopping_cart.order.model.Order;

import java.util.List;

public class GetOrdersResponse {
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public GetOrdersResponse() {
    }

    public GetOrdersResponse(List<Order> orders) {
        this.orders = orders;
    }
}

package com.xiedaimala.shopping_cart.order.controller;

import com.xiedaimala.shopping_cart.order.model.Order;
import com.xiedaimala.shopping_cart.order.model.OrderDao;
import com.xiedaimala.shopping_cart.order.view.*;
import com.xiedaimala.shopping_cart.product.model.Product;
import com.xiedaimala.shopping_cart.product.model.ProductDao;
import com.xiedaimala.shopping_cart.user.model.User;
import com.xiedaimala.shopping_cart.user.model.UserDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    private OrderDao orderDao;
    private UserDao userDao;
    private ProductDao productDao;

    public OrderController() {
    }

    public OrderController(OrderDao orderDao, UserDao userDao, ProductDao productDao) {
        this.orderDao = orderDao;
        this.userDao = userDao;
        this.productDao = productDao;
    }

    @GetMapping("/orders")
    public ResponseEntity<GetOrdersResponse> getOrders(){
        List<Order> orders = orderDao.findAll();
        return new ResponseEntity<>(new GetOrdersResponse(orders), HttpStatus.OK);
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<GetOrderResponse> getOrderById(@PathVariable long orderId){
        Order order = orderDao.getById(orderId);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new GetOrderResponse(order), HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderRequest createOrderRequest){
        User user = userDao.getById(createOrderRequest.getUserId());
        Product product = productDao.getById(createOrderRequest.getProductId());
        Order order = new Order(user, product, createOrderRequest.getQuantity(), createOrderRequest.getStatus(), createOrderRequest.getAddress());
        Order orderRes = orderDao.save(order);
        return new ResponseEntity<>(new CreateOrderResponse(orderRes), HttpStatus.CREATED);
    }

    @PutMapping("/orders/{orderId}")
    public ResponseEntity<UpdateOrderResponse> updateOrder(@PathVariable long orderId, @RequestBody UpdateOrderRequest updateOrderRequest) {
        Order order = orderDao.getById(orderId);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        String address = updateOrderRequest.getAddress();
        String status = updateOrderRequest.getStatus();
        long quantity = updateOrderRequest.getQuantity();

        if(!address.equals("")){
            order.setAddress(address);
        }
        if(!status.equals("")){
            order.setStatus(status);
        }
        if(quantity != 0){
            order.setQuantity(quantity);
        }
        Order orderRes = orderDao.save(order);
        return new ResponseEntity<>(new UpdateOrderResponse(orderRes), HttpStatus.OK);
    }

    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity deleteOrder(@PathVariable long orderId) {
        Order order = orderDao.getById(orderId);

        if (order == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        orderDao.delete(order);
        return new ResponseEntity(HttpStatus.OK);
    }
}

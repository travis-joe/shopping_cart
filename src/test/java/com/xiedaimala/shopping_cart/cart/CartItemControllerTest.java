package com.xiedaimala.shopping_cart.cart;

import com.xiedaimala.shopping_cart.cart.controller.CartController;
import com.xiedaimala.shopping_cart.cart.view.GetCartResponse;
import com.xiedaimala.shopping_cart.cart.view.ListCartResponse;
import com.xiedaimala.shopping_cart.cart.view.UpdateCartRequest;
import com.xiedaimala.shopping_cart.cart.view.UpdateCartResponse;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CartItemControllerTest {

    private CartController cartController = new CartController();

    @Test
    public void getCart() {
        ResponseEntity<GetCartResponse> response = cartController.getCart("123");
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void listCarts() {
        ResponseEntity<ListCartResponse> response = cartController.listCarts();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void updateCart() {
        List<String> products = new ArrayList<String>();
        ResponseEntity<UpdateCartResponse> response = cartController.updateCart("123", new UpdateCartRequest("谁的购物车", products));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
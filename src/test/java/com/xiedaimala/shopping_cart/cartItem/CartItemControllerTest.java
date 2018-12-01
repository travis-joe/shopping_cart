package com.xiedaimala.shopping_cart.cartItem;

import com.xiedaimala.shopping_cart.cartItem.controller.CartController;
import com.xiedaimala.shopping_cart.cartItem.view.GetCartItemResponse;
import com.xiedaimala.shopping_cart.cartItem.view.ListCartItemResponse;
import com.xiedaimala.shopping_cart.cartItem.view.UpdateCartItemRequest;
import com.xiedaimala.shopping_cart.cartItem.view.UpdateCartItemResponse;
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
        ResponseEntity<GetCartItemResponse> response = cartController.getCart("123");
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void listCarts() {
        ResponseEntity<ListCartItemResponse> response = cartController.listCarts();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void updateCart() {
        List<String> products = new ArrayList<String>();
        ResponseEntity<UpdateCartItemResponse> response = cartController.updateCart("123", new UpdateCartItemRequest("谁的购物车", products));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
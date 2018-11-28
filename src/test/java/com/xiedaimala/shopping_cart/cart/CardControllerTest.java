package com.xiedaimala.shopping_cart.cart;

import com.xiedaimala.shopping_cart.cart.model.GetCartResponse;
import com.xiedaimala.shopping_cart.cart.model.ListCartResponse;
import com.xiedaimala.shopping_cart.cart.model.UpdateCartRequest;
import com.xiedaimala.shopping_cart.cart.model.UpdateCartResponse;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CardControllerTest {

    private CardController cardController = new CardController();

    @Test
    public void getCart() {
        ResponseEntity<GetCartResponse> response = cardController.getCart("123");
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void listCarts() {
        ResponseEntity<ListCartResponse> response = cardController.listCarts();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void updateCart() {
        List<String> products = new ArrayList<String>();
        ResponseEntity<UpdateCartResponse> response = cardController.updateCart("123", new UpdateCartRequest("谁的购物车", products));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
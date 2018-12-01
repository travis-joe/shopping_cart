package com.xiedaimala.shopping_cart.cart.controller;

import com.xiedaimala.shopping_cart.cart.view.GetCartResponse;
import com.xiedaimala.shopping_cart.cart.view.ListCartResponse;
import com.xiedaimala.shopping_cart.cart.view.UpdateCartRequest;
import com.xiedaimala.shopping_cart.cart.view.UpdateCartResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    public CartController() {
    }

    @GetMapping("/carts/{cartID}")
    public ResponseEntity<GetCartResponse> getCart(@PathVariable String cartID) {
        return new ResponseEntity<>(new GetCartResponse(), HttpStatus.OK);
    }

    @GetMapping("/carts")
    public ResponseEntity<ListCartResponse> listCarts() {
        return new ResponseEntity<>(new ListCartResponse(), HttpStatus.OK);
    }

    @PutMapping("/carts/{cartId}")
    public ResponseEntity<UpdateCartResponse> updateCart(@PathVariable String cartId, @RequestBody UpdateCartRequest updateCartRequest){
        return new ResponseEntity<>(new UpdateCartResponse(), HttpStatus.OK);
    }

}

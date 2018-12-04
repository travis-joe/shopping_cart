//package com.xiedaimala.shopping_cart.cartItem;
//
//import com.xiedaimala.shopping_cart.cartItem.controller.CartController;
//import com.xiedaimala.shopping_cart.cartItem.view.GetCartItemResponse;
//import com.xiedaimala.shopping_cart.cartItem.view.ListCartItemResponse;
//import com.xiedaimala.shopping_cart.cartItem.view.UpdateCartItemRequest;
//import com.xiedaimala.shopping_cart.cartItem.view.UpdateCartItemResponse;
//import org.junit.Test;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//public class CartItemControllerTest {
//
//    private CartController cartController = new CartController();
//
//    @Test
//    public void getCart() {
//        ResponseEntity<GetCartItemResponse> response = cartController.getCartItem(123);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }
//
//    @Test
//    public void listCarts() {
//        ResponseEntity<ListCartItemResponse> response = cartController.listCartItem();
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }
//
//    @Test
//    public void updateCart() {
//        List<String> products = new ArrayList<String>();
//        ResponseEntity<UpdateCartItemResponse> response = cartController.updateCartItem(123, new UpdateCartItemRequest(12));
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }
//}
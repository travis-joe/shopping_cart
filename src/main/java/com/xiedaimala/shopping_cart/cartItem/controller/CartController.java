package com.xiedaimala.shopping_cart.cartItem.controller;

import com.xiedaimala.shopping_cart.cartItem.model.CartItem;
import com.xiedaimala.shopping_cart.cartItem.model.CartItemDao;
import com.xiedaimala.shopping_cart.cartItem.view.*;
import com.xiedaimala.shopping_cart.product.model.Product;
import com.xiedaimala.shopping_cart.product.model.ProductDao;
import com.xiedaimala.shopping_cart.user.model.User;
import com.xiedaimala.shopping_cart.user.model.UserDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    private UserDao userDao;
    private ProductDao productDao;
    private CartItemDao cartItemDao;

    public CartController() {
    }

    public CartController(UserDao userDao, ProductDao productDao, CartItemDao cartItemDao) {
        this.userDao = userDao;
        this.productDao = productDao;
        this.cartItemDao = cartItemDao;
    }

    @GetMapping("/cartItems/{cartID}")
    public ResponseEntity<GetCartItemResponse> getCartItem(@PathVariable String cartID) {
        return new ResponseEntity<>(new GetCartItemResponse(), HttpStatus.OK);
    }

    @GetMapping("/cartItems")
    public ResponseEntity<ListCartItemResponse> listCartItem() {
        return new ResponseEntity<>(new ListCartItemResponse(), HttpStatus.OK);
    }

    @PostMapping("/cartItems")
    public ResponseEntity<CreateCartItemResponse> createCartItem(CreateCartItemRequest createCartItemRequest){
        User user = userDao.getById(createCartItemRequest.getUser_id());
        Product product = productDao.getById(createCartItemRequest.getProduct_id());
        CartItem cartItem = cartItemDao.save(new CartItem(createCartItemRequest.getQuantity(), product,user));
        return new ResponseEntity<>(new CreateCartItemResponse(cartItem), HttpStatus.CREATED);
    }

    @PutMapping("/cartItems/{cartId}")
    public ResponseEntity<UpdateCartItemResponse> updateCartItem(@PathVariable String cartId, @RequestBody UpdateCartItemRequest updateCartItemRequest){
        return new ResponseEntity<>(new UpdateCartItemResponse(), HttpStatus.OK);
    }

}

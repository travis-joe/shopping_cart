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

import java.util.List;

@RestController
public class CartController {
    private UserDao userDao;
    private ProductDao productDao;
    private CartItemDao cartItemDao;

    public CartController(UserDao userDao, ProductDao productDao, CartItemDao cartItemDao) {
        this.userDao = userDao;
        this.productDao = productDao;
        this.cartItemDao = cartItemDao;
    }

    @GetMapping("/cartItems/{cartItemID}")
    public ResponseEntity<GetCartItemResponse> getCartItem(@PathVariable long cartItemID) {
        CartItem cartItem = cartItemDao.getCartItemById(cartItemID);
        if(cartItem != null) {
            return new ResponseEntity<>(new GetCartItemResponse(cartItem), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/cartItems")
    public ResponseEntity<ListCartItemResponse> listCartItem() {
        List<CartItem> cartItems = cartItemDao.findAll();
        if(cartItems == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ListCartItemResponse(cartItems), HttpStatus.OK);
    }

    @PostMapping("/cartItems")
    public ResponseEntity<CreateCartItemResponse> createCartItem(@RequestBody CreateCartItemRequest createCartItemRequest){
        User user = userDao.getById(createCartItemRequest.getUserId());
        Product product = productDao.getById(createCartItemRequest.getProductId());
        CartItem cartItem = cartItemDao.save(new CartItem(createCartItemRequest.getQuantity(), product,user));
        return new ResponseEntity<>(new CreateCartItemResponse(cartItem), HttpStatus.CREATED);
    }

    @PutMapping("/cartItems/{cartItemId}")
    public ResponseEntity<UpdateCartItemResponse> updateCartItem(@PathVariable long cartItemId, @RequestBody UpdateCartItemRequest updateCartItemRequest){
        CartItem cartItem = cartItemDao.getCartItemById(cartItemId);
        cartItem.setQuantity(updateCartItemRequest.getQuantity());
        CartItem cartItemRes = cartItemDao.save(cartItem);
        return new ResponseEntity<>(new UpdateCartItemResponse(cartItemRes), HttpStatus.OK);
    }

    @DeleteMapping("/cartItems/{cartItemId}")
    public ResponseEntity deleteCartItem(@PathVariable long cartItemId) {
        CartItem cartItem = cartItemDao.getCartItemById(cartItemId);
        if (cartItem == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        cartItemDao.delete(cartItem);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}

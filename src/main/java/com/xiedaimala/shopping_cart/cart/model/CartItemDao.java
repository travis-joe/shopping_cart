package com.xiedaimala.shopping_cart.cart.model;

import com.xiedaimala.shopping_cart.user.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemDao extends CrudRepository<CartItem, Long> {
    CartItem getCartItemById(long id);

    List<CartItem> findAll();

    CartItem save(CartItem cartItem);

    List<CartItem> getCartItemByUser(User user);

    void delete(CartItem cartItem);
}

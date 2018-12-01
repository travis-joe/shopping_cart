package com.xiedaimala.shopping_cart.order.model;

import com.xiedaimala.shopping_cart.user.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends CrudRepository<Order, Long> {
    Order getById(long id);

    List<Order> getByUser(User user);

    List<Order> findAll();

    Order save(Order order);

    void delete(Order order);
}

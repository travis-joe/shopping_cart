package com.xiedaimala.shopping_cart.user.controller;

import com.xiedaimala.shopping_cart.user.model.User;
import com.xiedaimala.shopping_cart.user.model.UserDao;
import com.xiedaimala.shopping_cart.user.view.CreateUserRequest;
import com.xiedaimala.shopping_cart.user.view.CreateUserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping("/users")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest createUserRequest){
        User user = userDao.save(new User(createUserRequest.getName(), createUserRequest.getPassword()));
        return new ResponseEntity<>(new CreateUserResponse(user.getId(), user.getName()), HttpStatus.CREATED);
    }
}

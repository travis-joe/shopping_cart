package com.xiedaimala.shopping_cart.user.view;

public class CreateUserRequest {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CreateUserRequest() {
    }

    public CreateUserRequest(String name, String password) {
        this.name = name;
        this.password = password;
    }
}

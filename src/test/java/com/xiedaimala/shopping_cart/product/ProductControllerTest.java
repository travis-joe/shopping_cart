package com.xiedaimala.shopping_cart.product;

import com.xiedaimala.shopping_cart.product.controller.ProductController;
import com.xiedaimala.shopping_cart.product.controller.validator.UpdateProductRequestValidator;
import com.xiedaimala.shopping_cart.product.model.ProductDao;
import com.xiedaimala.shopping_cart.product.controller.model.*;
import com.xiedaimala.shopping_cart.product.controller.validator.CreateProductRequestValidator;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class ProductControllerTest {
    private ProductDao productDao;
    private ProductController productController = new ProductController(new CreateProductRequestValidator(), new UpdateProductRequestValidator(), productDao);

    @Test
    public void shouldGetProductSuccessfully() {
        ResponseEntity<GetProductResponse> response = productController.getProduct(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void listProducts() {
        ResponseEntity<ListProductResponse> response = productController.listProducts();

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void createProduct() {
        ResponseEntity<CreateProductResponse> response = productController.createProduct(new CreateProductRequest("豆瓣酱", "猫咪喜欢吃", 112));
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void updateProduct() {
        ResponseEntity<UpdateProductResponse> response = productController.updateProduct(2L, new UpdateProductRequest("豆瓣酱", "猫咪喜欢吃", 112));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }



}

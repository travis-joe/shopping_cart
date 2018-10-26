package com.xiedaimala.shopping_cart.product;

import com.xiedaimala.shopping_cart.product.model.GetProductResponse;
import com.xiedaimala.shopping_cart.product.validator.CreateProductRequestValidator;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class ProductControllerTest {

    private ProductController productController = new ProductController(new CreateProductRequestValidator());

    @Test
    public void shouldGetProductSuccessfully() {
        ResponseEntity<GetProductResponse> response = productController.getProduct("123");

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}

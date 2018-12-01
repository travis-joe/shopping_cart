package com.xiedaimala.shopping_cart.product.controller;

import com.xiedaimala.shopping_cart.product.view.validator.UpdateProductRequestValidator;
import com.xiedaimala.shopping_cart.product.model.*;
import com.xiedaimala.shopping_cart.product.view.*;
import com.xiedaimala.shopping_cart.product.view.validator.CreateProductRequestValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductDao productDao;
    private CreateProductRequestValidator createProductRequestValidator;
    private UpdateProductRequestValidator updateProductRequestValidator;

    public ProductController(CreateProductRequestValidator createProductRequestValidator, UpdateProductRequestValidator updateProductRequestValidator,ProductDao productDao) {
        this.createProductRequestValidator = createProductRequestValidator;
        this.updateProductRequestValidator = updateProductRequestValidator;
        this.productDao = productDao;
    }

    /**
     * List products
     */
    @GetMapping("/products")
    public ResponseEntity<ListProductResponse> listProducts() {
        List<Product> products = productDao.findAll();
        if(products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(new ListProductResponse(products), HttpStatus.OK);
        }
    }

    /**
     * Get product
     */
    @GetMapping("/products/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable long productId) {
        Product product = productDao.getById(productId);

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new GetProductResponse(product), HttpStatus.OK);
        }
    }

    /**
     * Create product
     */
    @PostMapping("/products")
    public ResponseEntity<CreateProductResponse> createProduct(@RequestBody CreateProductRequest createProductRequest) {
        // 实现
        boolean validate = createProductRequestValidator.validate(createProductRequest);
        if(validate){
            Product product = productDao.save(createProductRequest.toProduct());
            if(product != null){
                return new ResponseEntity<>(new CreateProductResponse(product), HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Update product
     */
    @PutMapping("/products/{productId}")
    public ResponseEntity<UpdateProductResponse> updateProduct(@PathVariable Long productId, @RequestBody UpdateProductRequest updateProductRequest) {
        boolean validate = updateProductRequestValidator.validate(updateProductRequest);
        if(validate){
            Product product = productDao.save(updateProductRequest.toProduct(productId));
            if(product != null){
                return new ResponseEntity<>(new UpdateProductResponse(product), HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
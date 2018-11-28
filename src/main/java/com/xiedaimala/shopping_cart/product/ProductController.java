package com.xiedaimala.shopping_cart.product;

import com.xiedaimala.shopping_cart.product.model.*;
import com.xiedaimala.shopping_cart.product.model.api.*;
import com.xiedaimala.shopping_cart.product.validator.CreateProductRequestValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private ProductDao productDao;
    private CreateProductRequestValidator createProductRequestValidator;

    public ProductController(CreateProductRequestValidator createProductRequestValidator, ProductDao productDao) {
        this.createProductRequestValidator = createProductRequestValidator;
        this.productDao = productDao;
    }

    /**
     * List products
     */
    @GetMapping("/products")
    public ResponseEntity<ListProductResponse> listProducts() {
        return new ResponseEntity<>(new ListProductResponse(), HttpStatus.OK);
    }

    /**
     * Get product
     */
    @GetMapping("/products/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable int productId) {
        Product product = productDao.get(productId);
        return new ResponseEntity<>(new GetProductResponse(product), HttpStatus.OK);
    }

    /**
     * Create product
     */
    @PostMapping("/products")
    public ResponseEntity<CreateProductResponse> createProduct(@RequestBody CreateProductRequest createProductRequest) {
        // 实现
        boolean validate = createProductRequestValidator.validate(createProductRequest);

        return new ResponseEntity<>(new CreateProductResponse(), HttpStatus.CREATED);
    }

    /*
     * 已经定义好了输入和输出!
     * 同时也定义好了期望的输入内容和相应的执行结果!
     * 想象成一个黑箱, 是不是可以写测试了, 即使没有实现, 但是起始状态测试是不能通过的, 只是用来帮助我们明确功能
     * 开发就转换成写代码让测试通过! --> 符合功能的逻辑要求! 其实这个就是测试驱动开发!
     */

    /**
     * Update product
     */
    @PutMapping("/products/{productId}")
    public ResponseEntity<UpdateProductResponse> updateProduct(@PathVariable String productId, @RequestBody UpdateProductRequest updateProductRequest) {
        return new ResponseEntity<>(new UpdateProductResponse(), HttpStatus.OK);
    }
}

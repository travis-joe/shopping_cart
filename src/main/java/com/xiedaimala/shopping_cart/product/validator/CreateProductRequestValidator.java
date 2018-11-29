package com.xiedaimala.shopping_cart.product.validator;

import com.xiedaimala.shopping_cart.product.model.api.CreateProductRequest;
import org.springframework.stereotype.Component;

@Component
public class CreateProductRequestValidator {

    public boolean validate(CreateProductRequest createProductRequest) {
        if (createProductRequest.getPrice() < 0)
            return false;
        return createProductRequest.getName().length() > 0;
    }
}

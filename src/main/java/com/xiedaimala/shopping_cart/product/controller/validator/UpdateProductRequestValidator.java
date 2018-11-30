package com.xiedaimala.shopping_cart.product.controller.validator;

import com.xiedaimala.shopping_cart.product.controller.model.UpdateProductRequest;
import org.springframework.stereotype.Component;

@Component
public class UpdateProductRequestValidator {
    public boolean validate(UpdateProductRequest updateProductRequest) {
        if (updateProductRequest.getPrice() < 0)
            return false;
        return updateProductRequest.getName().length() > 0;
    }
}

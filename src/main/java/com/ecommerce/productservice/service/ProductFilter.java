package com.ecommerce.productservice.service;

import com.ecommerce.productservice.model.Product;
@FunctionalInterface
public interface ProductFilter {
    boolean filter(Product product);
}

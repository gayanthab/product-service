package com.ecommerce.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.ecommerce.productservice.model.Product;
import com.ecommerce.productservice.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
/*
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable String productId) {
        Optional<Product> productOptional = productService.getProductById(productId);

        if(productOptional.isPresent()) {
            return ResponseEntity.ok(productOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {

        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable String productId, @RequestBody Product product) {

        Product updatedProduct = productService.updateProduct(productId, product);
        if(updatedProduct !=null){
            return ResponseEntity.ok(updatedProduct);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter/{maxPrice}")
    public ResponseEntity<List<Product>> filterProductsByPrice(@PathVariable double maxPrice){
        List<Product> filteredProductList =  productService.filterProductsByPrice(maxPrice);
        return ResponseEntity.ok(filteredProductList);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Product>> filterProductsByName(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "name") String sort,
            @RequestParam(value = "direction", defaultValue = "asc") String direction) {

            // Create a Pageable object for pagination and sorting
            PageRequest pageable = PageRequest.of(page, size, Sort.Direction.fromString(direction), sort);
            List<Product> filteredProduct =  productService.getProductByName(name,pageable);

            return ResponseEntity.ok(filteredProduct);
    }

 */
}
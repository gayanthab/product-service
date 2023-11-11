package com.ecommerce.productservice;

import com.ecommerce.productservice.model.Product;
import com.ecommerce.productservice.repository.ProductRepository;
import com.ecommerce.productservice.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    List<Product> products;

    @BeforeEach
    public void init() {
        // Initialize Mockito annotations
        MockitoAnnotations.initMocks(this);
        products = Arrays.asList(
                new Product("1", "Product 1", "Description 1", 19.99),
                new Product("2", "Product 2", "Description 1", 29.99),
                new Product("3", "Product 3", "Description 3", 39.99)
        );
    }

    @Test
    public void testGetAllProducts() {

        // Mock the behavior of the productRepository
        when(productRepository.findAll()).thenReturn(products);

        // Act
        List<Product> actualProducts = productService.getAllProducts();

        // Assert
        assertEquals(products.size(), actualProducts.size());
    }

    // Add more test methods for other service methods

    @Test
    public void testSaveProduct() {
        // Arrange
        Product productToSave = new Product("1","name 1","description 1", 19.99f);
        // Mock the behavior of the productRepository save method
        when(productRepository.save(productToSave)).thenReturn(productToSave);

        // Act
        Product savedProduct = productService.createProduct(productToSave);

        // Assert
        assertEquals(productToSave, savedProduct);
    }

    // Add more test methods for other service methods
    @Test
    public void testFilterProductsByPrice() {

        when(productRepository.findAll()).thenReturn(products);
        // Act: Call the method that filters products by price
        List<Product> filteredProducts = productService.filterProductsByPrice(30.00);

        // Assert: Verify the filtered products
        assertEquals(2, filteredProducts.size());
    }

    @Test
    public void testGetProductNames(){

        when(productRepository.findAll()).thenReturn(products);
        // Assert: Verify the product names
        assertEquals(products.get(0).getName(),productService.getAllProductNames().get(0));

    }

    @Test
    void testGetProductMap(){
        when(productRepository.findAll()).thenReturn(products);

       Map<String,Product> ProductMap = productService.getProductMap();
        assertEquals(products.get(0).getName(),ProductMap.get("1").getName());
    }

    @Test
    void testProductByDescription(){
        when(productRepository.findAll()).thenReturn(products);
        Map<String,List<Product>> productListByCatagory = productService.productByCatagory();
        assertEquals(products.get(0).getName(),productListByCatagory.get("Description 1").get(0).getName());
    }

    @Test
    void testExpensiveAndAffordableProducts(){
        when(productRepository.findAll()).thenReturn(products);
        Map<Boolean,List<Product>> expensiveAndAffordableProducts = productService.expensiveAndAffordableProducts();
        assertEquals(products.get(2).getName(),expensiveAndAffordableProducts.get(true).get(1).getName());
    }

}


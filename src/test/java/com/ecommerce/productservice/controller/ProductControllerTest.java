package com.ecommerce.productservice.controller;

import com.ecommerce.productservice.model.Product;
import com.ecommerce.productservice.service.ProductService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.MediaType;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.Mockito.when;

public class ProductControllerTest {
    private MockMvc mockMvc;

    @Mock
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new ProductController(productService)).build();
    }

    @Test
    public void testFilterProductsByPrice() throws Exception {
        // Arrange
        List<Product> products = Arrays.asList(
                new Product("1", "Product 1", "Description 1", 19.99),
                new Product("2", "Product 2", "Description 2", 29.99),
                new Product("3", "Product 3", "Description 3", 39.99)
        );
        double maxPrice = 50.0;
        String url = String.format("/products/filter/%.1f", maxPrice);

        when(productService.filterProductsByPrice(maxPrice)).thenReturn(products);

                mockMvc.perform(MockMvcRequestBuilders
                .get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Product 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Product 2"));
    }
}

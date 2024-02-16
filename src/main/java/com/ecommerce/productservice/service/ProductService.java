package com.ecommerce.productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.ecommerce.productservice.model.Product;
//import com.ecommerce.productservice.repository.ProductRepository;

@Service
public class ProductService {
   // private final ProductRepository productRepository;

    private List<Product> productList = new ArrayList<Product>();


  //  @Autowired
  //  public ProductService(ProductRepository productRepository) {
  //      this.productRepository = productRepository;
   // }


    public ProductService() {
         this.productList.add(new Product("id1","name1","des1",11.0));
        this.productList.add(new Product("id2","name2","des1",12.0));
        this.productList.add(new Product("id3","name3","des1",13.0));
     }

    public List<Product> getAllProducts() {
 //       return productRepository.findAll();
        return this.productList;
    }

   /* public Optional<Product> getProductById(String productId) {

        return productRepository.findById(productId);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(String productId, Product product) {
        if (productRepository.existsById(productId)) {
            //product.setId(productId);
            return productRepository.save(product);
        }
        return null; // Product with the given ID does not exist
    }

    public void deleteProduct(String productId) {

        productRepository.deleteById(productId);
    }

    public List<Product> filterProductsByPrice(double maxPrice){

     // List <Product> products = this.getAllProducts();
    //  return products.stream().filter(product -> product.getPrice() <= maxPrice).collect(Collectors.toList());
        ProductFilter filterCriteria = product -> product.getPrice() <=maxPrice;
        return this.filterProduct(filterCriteria);
    }

   public List<String> getAllProductNames(){
        List<Product> products = this.getAllProducts();
        return products.stream().map(Product::getName).collect(Collectors.toList());
    }

    public Map<String,Product> getProductMap(){

        List<Product> products = this.getAllProducts();
        return products.stream().collect(Collectors.toMap(Product::getId, Function.identity()));
    }

    public Map<String,List<Product>> productByCatagory(){

        List<Product> products = this.getAllProducts();
        return products.stream().collect(Collectors.groupingBy(Product::getDescription));
    }

    public Map<Boolean,List<Product>> expensiveAndAffordableProducts(){
        List<Product> products = this.getAllProducts();
        return products.stream().collect(Collectors.partitioningBy(p-> p.getPrice() > 25));
    }

    private List<Product> filterProduct(ProductFilter filterCriteria){

        List<Product> products = this.getAllProducts();

        return products.stream().filter(filterCriteria::filter).collect(Collectors.toList());

    }

    public List<Product> getProductByName(String productName, Pageable pageable){
        return productRepository.findByName(productName,pageable);
    }
*/
}

package com.pharmacy.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pharmacy.entities.Category;
import com.pharmacy.entities.Product;
import com.pharmacy.repositories.CategoryRepository;
import com.pharmacy.repositories.ProductRepository;

import lombok.AllArgsConstructor;

//TODO: make Hibernate automatically check Category by name
//TODO: error handling
@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
       Category category = categoryRepository.findByName(product.getCategory().getName());
       product.setCategory(category);
       productRepository.save(product);
    }

    public Product findProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public void updateProduct(Product product) {
        Category category = categoryRepository.findByName(product.getCategory().getName());
        product.setCategory(category);
        productRepository.save(product);
    }
}

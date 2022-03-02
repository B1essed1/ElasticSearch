package com.example.elasticsearch;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    Product  save(Product product){
       return productRepository.save(product);
    }

    List<Product>  findAllByName(String name){
        List<Product> products = productRepository.findByNameContaining(name);
        if (!products.isEmpty())  return products; else return null;
    }
}

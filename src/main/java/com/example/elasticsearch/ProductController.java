package com.example.elasticsearch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.util.List;

@RestController
@RequestMapping("/api/elastic")
@Slf4j
public class ProductController {

    private final ProductServiceImpl service;

    @Autowired
    public ProductController(ProductServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestBody Product product){
        return ResponseEntity.ok(service.save(product));

    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(@RequestParam("name") String name){
        log.info("name     {}", name);
        log.debug("name     {}", name);
        List<Product> products = service.findAllByName(name);
        if (products == null) throw new RuntimeException("Product Not Found");
        else  return ResponseEntity.ok(products);
    }


}

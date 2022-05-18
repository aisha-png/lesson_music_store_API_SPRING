package com.bnta.music_store.controllers;

import com.bnta.music_store.models.Product;
import com.bnta.music_store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }

//        TODO: SHOW MAPPING
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProduct(@PathVariable Long id){
        var product = productRepository.findById(id);
//        ternary operator: condition ? statement : false statement
        return new ResponseEntity<>(product, product.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

//    TODO : CREATE
    @PostMapping
    public void createProduct(@RequestBody Product product){
        productRepository.save(product);
    }
}

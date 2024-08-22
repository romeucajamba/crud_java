package com.romeu.crud_java.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;

import com.romeu.crud_java.domain.product.Product;
import com.romeu.crud_java.domain.product.ProductRepository;
import com.romeu.crud_java.domain.product.RequestProductDTO;

/*Essa anotação RestController avisa ao spring que isso é um controller */
@RestController

/*Essa anotação vai dizer para o meu controle qual a rota ou endpoint que ele é responsável */
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    // Responsável por cuidar das requisições do tipo GET
    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity<?> registerProduct(@RequestBody @Valid RequestProductDTO data) {
         Product newProduct = new Product(data);
        repository.save(newProduct);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody @Valid RequestProductDTO data) {
        Optional<Product> optionalProduct = repository.findById(id);
    
        if (optionalProduct.isEmpty()) {
            return ResponseEntity.notFound().build(); // Retorna 404 se o produto não for encontrado
        }
    
        Product product = optionalProduct.get();
        product.setName(data.name());
        product.setPrice(data.price());
    
        repository.save(product);
    
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        Optional<Product> product = repository.findById(id);
        
        if (product.isEmpty()) {
            return ResponseEntity.notFound().build(); // Retorna 404 se o produto não for encontrado
        }
        
        repository.deleteById(id);
        return ResponseEntity.ok().build(); 
    }    
}
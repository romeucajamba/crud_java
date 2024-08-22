package com.romeu.crud_java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

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
        System.out.println(data);
        return ResponseEntity.ok().build();
    }
}

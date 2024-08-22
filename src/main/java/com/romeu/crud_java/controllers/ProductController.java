package com.romeu.crud_java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romeu.crud_java.domain.product.ProductRepository;
/*Essa anotação ResController avisa ao spring que isso é um controller */
@RestController

/*Essa anotação vai dizer para o meu controle qual a rota ou endpoint que ele é responsavel */
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    private ProductRepository repository;
    //Responsavel por cuidar das requisiçoes do tipo get
    @GetMapping 

    public ResponseEntity getAllProducts(){
        var allProducts = repository.findAll();

        return ResponseEntity.ok(allProducts);
    }
}

package com.nag.simpleWebApp.controller;

import com.nag.simpleWebApp.model.Product;
import com.nag.simpleWebApp.service.ProdutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    ProdutService service;

    @GetMapping
    public List<Product> getProducts(){
        return service.getProducts();
    }

    @GetMapping(path = "{prodId}")
    public Product getProductById(@PathVariable int prodId){
        return service.getProductById(prodId);
    }

    @PostMapping
    public void addProduct(@RequestBody Product prod){
        System.out.println(prod);
        service.addProduct(prod);
    }

    @PutMapping(path = "{id}")
    public Product editById(@PathVariable int id, @RequestBody Product product){
        return service.editById(id,product);
    }

    @DeleteMapping(path = "{id}")
    public void deleteById(@PathVariable int id){
        service.deleteById(id);
    }
}

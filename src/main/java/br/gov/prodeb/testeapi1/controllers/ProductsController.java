package br.gov.prodeb.testeapi1.controllers;

import br.gov.prodeb.testeapi1.entities.Product;
import br.gov.prodeb.testeapi1.exceptions.ResourceNotFoundException;
import br.gov.prodeb.testeapi1.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productService.findAll();

        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable String id) throws ResourceNotFoundException {
        Product product = productService.findById(id);

        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> findById(@Valid @RequestBody Product product) {
        Product newProduct = productService.create(product);

        return ResponseEntity.created(null).body(newProduct);
    }

}

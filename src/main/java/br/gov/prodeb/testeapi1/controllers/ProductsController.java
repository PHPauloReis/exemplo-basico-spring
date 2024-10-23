package br.gov.prodeb.testeapi1.controllers;

import br.gov.prodeb.testeapi1.entities.Product;
import br.gov.prodeb.testeapi1.exceptions.ResourceNotFoundException;
import br.gov.prodeb.testeapi1.http.dto.ViaCepResponse;
import br.gov.prodeb.testeapi1.services.AddressService;
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

    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productService.findAll();

        return ResponseEntity.ok(products);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> search(@RequestParam String name) {
        List<Product> products = productService.findByName(name);

        return ResponseEntity.ok(products);
    }

    @GetMapping("/promotion")
    public ResponseEntity<List<Product>> promotion() {
        List<Product> products = productService.findSpecialPromo(600);

        return ResponseEntity.ok(products);
    }

    @GetMapping("/cep")
    public ResponseEntity<String> getAddressByCep(@RequestParam String cep) {

        ViaCepResponse viaCepResponse = addressService.getAddressByCep(cep);

        return ResponseEntity.ok("O endereço fica na rua: " + viaCepResponse.getLogradouro());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable String id) throws ResourceNotFoundException {
        Product product = productService.findById(id);

        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> save(@Valid @RequestBody Product product) {
        Product newProduct = productService.create(product);

        return ResponseEntity.created(null).body(newProduct);
    }

}

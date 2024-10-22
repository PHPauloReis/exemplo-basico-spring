package br.gov.prodeb.testeapi1.services;

import br.gov.prodeb.testeapi1.entities.Product;
import br.gov.prodeb.testeapi1.exceptions.ResourceNotFoundException;
import br.gov.prodeb.testeapi1.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product findById(String id) throws ResourceNotFoundException {
        Optional<Product> product = productRepository.findById(id);

        if (product.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return product.get();
    }
}

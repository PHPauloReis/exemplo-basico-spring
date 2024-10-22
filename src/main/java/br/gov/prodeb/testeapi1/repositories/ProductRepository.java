package br.gov.prodeb.testeapi1.repositories;

import br.gov.prodeb.testeapi1.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}

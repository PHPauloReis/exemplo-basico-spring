package br.gov.prodeb.testeapi1.repositories;

import br.gov.prodeb.testeapi1.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findByName(String name);

    @Query("{ $or: [ { name: \"CPU Ryzen 3\" }, { price: ?0 } ] }")
    List<Product> findSpecialPromo(int price);

}

package saurav.springjpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import saurav.springjpa.models.Product;

@Component
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
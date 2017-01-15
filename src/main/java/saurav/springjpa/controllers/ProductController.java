package saurav.springjpa.controllers;

import jersey.repackaged.com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import saurav.springjpa.models.Product;
import saurav.springjpa.repositories.ProductRepository;

/**
 * Created by saurav on 12/31/16.
 */
@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> listProducts() throws Exception {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) throws Exception {
        return productRepository.findOne(id);
    }

    public Product saveProduct(Product product) throws Exception {
        Preconditions.checkNotNull(product, "Product can't be null");
        Product prod = productRepository.save(product);
        return prod;

    }

}

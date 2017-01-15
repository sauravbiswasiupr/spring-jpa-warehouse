package saurav.springjpa.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import saurav.springjpa.configuration.RepositoryConfiguration;
import saurav.springjpa.models.Product;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by saurav on 9/19/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class ProductRepositoryTest {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Test
    public void testSaveProduct() {
        Product product = new Product();
        product.setDescription("Saurav's t-shirt");
        product.setProductId("1234");
        product.setPrice(new BigDecimal("20.5"));

        assertNull(product.getId());
        productRepository.save(product);
        assertNotNull(product.getId());

        // Fetch from database
        Product fetchedProduct = productRepository.findOne(product.getId());
        assertNotNull(fetchedProduct);
        assertEquals(fetchedProduct.getId(), product.getId());
        assertEquals(fetchedProduct.getDescription(), product.getDescription());
    }
}
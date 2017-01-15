package saurav.springjpa.resources;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import saurav.springjpa.controllers.ProductController;
import saurav.springjpa.models.Product;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by saurav on 12/31/16.
 */
@Slf4j
@Component
@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {
    protected Logger log = LoggerFactory.getLogger(ProductResource.class);

    @Autowired
    private ProductController productController;

    @GET
    @Path("/products")
    public Response index() throws Exception {
        log.info("Received request to list all items");
        Iterable<Product> products = productController.listProducts();
        return Response.ok(products).build();
    }

    @GET
    @Path("/products/{id}")
    public Product getProductById(@PathParam("id") Integer id) throws Exception {
        log.info("Received request to list the item details for id: " + id);
        Product product  = productController.getProductById(id);
        return product;
    }

    @POST
    @Path("/products/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveProduct(Product product) throws Exception {
        log.info("Received request to save a product to the database");
        Product productSaved = productController.saveProduct(product);
        return Response.ok(productSaved).build();
    }
}

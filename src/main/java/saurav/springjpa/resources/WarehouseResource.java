package saurav.springjpa.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import saurav.springjpa.controllers.WarehouseController;
import saurav.springjpa.models.Product;
import saurav.springjpa.models.ProductRequest;
import saurav.springjpa.models.Warehouse;
import saurav.springjpa.models.WarehouseRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;

/**
 * Created by saurav on 1/1/17.
 */
@Component
@Path("/warehouse")
@Produces(MediaType.APPLICATION_JSON)
public class WarehouseResource {

    @Autowired
    private WarehouseController warehouseController;

    @GET
    @Path("/warehouses")
    public Response listAllWarehouses() {
        Iterable<Warehouse> warehouses = warehouseController.listAllWarehouses();
        return Response.ok(warehouses).build();
    }

    @POST
    @Path("/warehouses/saveproduct")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveProductToWarehouse(WarehouseRequest warehouseRequest) {
        Integer warehouseId = warehouseRequest.getWarehouseId();
        ProductRequest productRequest = warehouseRequest.getProductRequest();

        Integer version = productRequest.getVersion();
        String description = productRequest.getDescription();
        String imageurl = productRequest.getImageurl();
        BigDecimal price = productRequest.getPrice();

        Product product = new Product(version, description, imageurl, price);
        warehouseController.saveProductToWarehouse(warehouseId, product);
        Iterable<Product> warehouseProducts = warehouseController.listProductsInWarehouse(warehouseId);
        return Response.ok(warehouseProducts).build();
    }

    @POST
    @Path("/warehouses/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createWarehouse(Warehouse warehouse) {
        Warehouse warehouseSaved = warehouseController.createWarehouse(warehouse);
        return Response.ok(warehouseSaved).build();
    }

}

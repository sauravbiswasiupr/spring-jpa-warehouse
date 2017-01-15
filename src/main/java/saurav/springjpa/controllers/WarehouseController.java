package saurav.springjpa.controllers;

import jersey.repackaged.com.google.common.base.Preconditions;
import jersey.repackaged.com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import saurav.springjpa.models.Product;
import saurav.springjpa.models.Warehouse;
import saurav.springjpa.repositories.WarehouseRepository;

import java.util.Set;

/**
 * Created by saurav on 1/1/17.
 */
@Controller
public class WarehouseController {

    @Autowired
    private WarehouseRepository warehouseRepository;

    private Logger log = LoggerFactory.getLogger(WarehouseController.class);

    public Warehouse createWarehouse(Warehouse warehouse) {
        log.info("Attempting to create a new warehouse");
        Preconditions.checkNotNull(warehouse, "Warehouse can't be null");
        warehouseRepository.save(warehouse);
        log.info("Created warehouse successfully");
        return warehouse;
    }

    public void saveProductToWarehouse(Integer warehouseId, Product product) {
        log.info("Attempting to save product to warehouse");
        Warehouse warehouse = warehouseRepository.findOne(warehouseId);
        Set<Product> products = Sets.newHashSet();
        product.setWarehouse(warehouse);
        products.add(product);
        warehouse.setProducts(products);
        warehouseRepository.save(warehouse);
    }

    public Iterable<Product> listProductsInWarehouse(Integer warehouseId) {
        Warehouse warehouse = warehouseRepository.findOne(warehouseId);
        return warehouse.getProducts();
    }

    public Iterable<Warehouse> listAllWarehouses() {
        return warehouseRepository.findAll();
    }
}

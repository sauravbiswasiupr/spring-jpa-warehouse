package saurav.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import saurav.springjpa.models.Warehouse;

/**
 * Created by saurav on 1/1/17.
 */
@Component
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
}

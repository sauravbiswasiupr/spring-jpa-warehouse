package saurav.springjpa.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.ws.rs.Produces;

/**
 * Created by saurav on 1/1/17.
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class WarehouseRequest {
    private ProductRequest productRequest;
    private Integer warehouseId;

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public void setProductRequest(ProductRequest productRequest) {
        this.productRequest = productRequest;
    }

    public ProductRequest getProductRequest() {
        return productRequest;
    }
}

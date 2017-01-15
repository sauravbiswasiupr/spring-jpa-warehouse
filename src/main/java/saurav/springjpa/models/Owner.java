package saurav.springjpa.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created by saurav on 12/31/16.
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Owner {
    private String name;
    private List<Warehouse> warehousesOwned;
}

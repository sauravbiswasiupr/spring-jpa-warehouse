package saurav.springjpa.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by saurav on 12/31/16.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Location {
    private BigDecimal latitude;
    private BigDecimal longitude;
}

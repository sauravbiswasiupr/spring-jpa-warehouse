package saurav.springjpa.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by saurav on 12/31/16.
 */

@Entity
@Table(name = "warehouse")
public class Warehouse {

    private Integer id;
    private Set<Product> products;
    private String name;

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "warehouse", cascade = CascadeType.ALL)
    public Set<Product> getProducts() {
        return products;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

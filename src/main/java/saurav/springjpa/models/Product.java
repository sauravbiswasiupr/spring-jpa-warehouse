package saurav.springjpa.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import java.math.BigDecimal;

/**
 * Created by saurav on 9/19/16.
 */
@Entity
@Table(name = "product")
public class Product {
    private Integer id;

    @Version
    private Integer version;

    private String description;
    private String imageurl;
    private BigDecimal price;
    private Warehouse warehouse;

    public Product() {

    }

    public Product(Integer version, String description, String imageurl, BigDecimal price) {
        this.version = version;
        this.description = description;
        this.imageurl = imageurl;
        this.price = price;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    public Warehouse getWarehouse() {
        return warehouse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageUrl) {
        this.imageurl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
 }

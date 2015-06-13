package ro.dezertatie.domain.product;


import org.apache.commons.lang.builder.ToStringBuilder;
import ro.dezertatie.common.domain.BaseEntity;
import ro.dezertatie.domain.product.status.ProductStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Product extends BaseEntity<String> {

    private String name;
    private String description;
    private String shortName;
    private ProductStatus productStatus;

    public Product() {
    }

    public Product(String Id) {
        super(Id);
    }

    public Product(String name, String description, String shortName, ProductStatus productStatus) {
        this.name = name;
        this.description = description;
        this.shortName = shortName;
        this.productStatus = productStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @OneToMany
    @Column(name = "product_status_id")
    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("description", description)
                .append("shortName", shortName)
                .append("productStatus", productStatus)
                .toString();
    }

}

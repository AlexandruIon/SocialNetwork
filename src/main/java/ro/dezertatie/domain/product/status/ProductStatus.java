package ro.dezertatie.domain.product.status;

import ro.dezertatie.common.domain.TypeBaseEntity;

import javax.persistence.Entity;

@Entity
public class ProductStatus extends TypeBaseEntity<String> {

    public ProductStatus() {
    }

    public ProductStatus(String id) {
        super(id);
    }

    public ProductStatus(String id, String value, String description) {
        super(id, value, description);
    }
}

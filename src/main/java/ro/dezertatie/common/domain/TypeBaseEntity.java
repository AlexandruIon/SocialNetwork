package ro.dezertatie.common.domain;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class TypeBaseEntity<I extends Serializable> extends BaseEntity<I> {

    private String value;
    private String description;

    protected TypeBaseEntity() {

    }

    protected TypeBaseEntity(I id) {
        super(id);
    }

    public TypeBaseEntity(I id, String value, String description) {
        super(id);
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

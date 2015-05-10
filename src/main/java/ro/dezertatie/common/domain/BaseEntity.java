package ro.dezertatie.common.domain;


import java.io.Serializable;

public class BaseEntity<I extends Serializable> {

    private I id;

    public BaseEntity() {

    }

    public BaseEntity(I Id) {
        this.id = id;
    }
}

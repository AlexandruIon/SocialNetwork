package ro.dezertatie.domain.address;

import ro.dezertatie.common.domain.TypeBaseEntity;

import javax.persistence.Entity;

@Entity
public class AddressType extends TypeBaseEntity<String> {

    public AddressType() {
    }

    public AddressType(String id) {
        super(id);
    }
}

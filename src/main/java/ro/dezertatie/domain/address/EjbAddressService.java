package ro.dezertatie.domain.address;


import org.apache.commons.lang.NullArgumentException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collection;

@Stateless
public class EjbAddressService implements AddressService {

    @Inject
    private AddressDao addressDao;

    public Address create(Address entity) {
        return createOrUpdate(entity);
    }

    public Address update(Address entity) {
        return createOrUpdate(entity);
    }

    private Address createOrUpdate(Address entity) {
        if (entity == null) {
            throw new NullArgumentException("Null not allowed");
        }
        try {
            return addressDao.save(entity);
        } catch (IllegalArgumentException e) {
            throw new AddressException("Failed to persist address", e);
        }
    }

    public void delete(Address entity) {
        if (entity == null) {
            throw new NullArgumentException("Null not allowed");
        }
        deleteById(entity.getId());
    }

    public void deleteById(String id) {
        try {
            addressDao.delete(id);
        } catch (IllegalArgumentException e) {
            throw new AddressException("Failed to delete address", e);
        }
    }

    public Address get(String id) {
        Address address;
        try {
            address = addressDao.findOne(id);
        } catch (IllegalArgumentException e) {
            throw new AddressException("Failed to retrieve address", e);
        }
        if (address == null) {
            throw new AddressException("Address not found");
        }
        return address;
    }

    public Collection<Address> getAll() {
        return addressDao.findAll();
    }

    public Collection<Address> getAll(long offset, long limit) {
        throw new UnsupportedOperationException();
    }
}


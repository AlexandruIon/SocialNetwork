package ro.dezertatie.domain.organization;


import org.apache.commons.lang.NullArgumentException;
import ro.dezertatie.domain.address.Address;
import ro.dezertatie.domain.contact.Contact;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collection;

@Stateless
public class EjbOrganizationService implements OrganizationService {

    @Inject
    private OrganizationDao organizationDao;

    public Organization create(Organization entity) {
        return createOrUpdate(entity);
    }

    public Organization update(Organization entity) {
        return createOrUpdate(entity);
    }

    private Organization createOrUpdate(Organization entity) {
        if (entity == null) {
            throw new NullArgumentException("Null not allowed");
        }
        try {
            return organizationDao.save(entity);
        } catch (IllegalArgumentException e) {
            throw new OrganizationException("Failed to persist organization", e);
        }
    }


    public void delete(Organization entity) {
        if (entity == null) {
            throw new NullArgumentException("Null not allowed");
        }
        deleteById(entity.getId());
    }

    public void deleteById(String id) {
        try {
            organizationDao.delete(id);
        } catch (IllegalArgumentException e) {
            throw new OrganizationException("Failed to delete organization", e);
        }
    }

    public Organization get(String id) {
        Organization organization;
        try {
            organization = organizationDao.findOne(id);
        } catch (IllegalArgumentException e) {
            throw new OrganizationException("Failed to retrieve organization", e);
        }
        if (organization == null) {
            throw new OrganizationException("User not found");
        }
        return organization;
    }

    public Collection<Organization> getAll() {
        return organizationDao.findAll();
    }

    public Collection<Organization> getAll(long offset, long limit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public OrganizationType getOrganizationType(String organizationTypeId) {
        return null;
    }

    @Override
    public Collection<OrganizationType> getAllOrganizationTypes() {
        return null;
    }

    @Override
    public Address createAddress(String organizationId, Address address) {
        return null;
    }

    @Override
    public Address updateAddress(String organizationId, Address address) {
        return null;
    }

    @Override
    public Collection<Address> getAddresses(String organizationId) {
        return null;
    }

    @Override
    public void deleteAddress(String organizationId, String addressId) {

    }

    @Override
    public Contact createContact(String organizationId, Contact contact) {
        return null;
    }

    @Override
    public Contact updateContact(String organizationId, Contact contact) {
        return null;
    }

    @Override
    public Collection<Contact> getContacts(String organizationId) {
        return null;
    }

    @Override
    public void deleteContact(String organizationId, String contactId) {

    }
}

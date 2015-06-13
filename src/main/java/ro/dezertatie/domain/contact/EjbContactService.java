package ro.dezertatie.domain.contact;


import org.apache.commons.lang.NullArgumentException;

import javax.inject.Inject;
import java.util.Collection;

public class EjbContactService implements ContactService {

    @Inject
    private ContactDao contactDao;

    public Contact create(Contact entity) {
        return createOrUpdate(entity);
    }

    public Contact update(Contact entity) {
        return createOrUpdate(entity);
    }

    private Contact createOrUpdate(Contact entity) {
        if (entity == null) {
            throw new NullArgumentException("Null not allowed");
        }
        try {
            return contactDao.save(entity);
        } catch (IllegalArgumentException e) {
            throw new ContactException("Failed to persist contact", e);
        }
    }


    public void delete(Contact entity) {
        if (entity == null) {
            throw new NullArgumentException("Null not allowed");
        }
        deleteById(entity.getId());
    }

    public void deleteById(String id) {
        try {
            contactDao.delete(id);
        } catch (IllegalArgumentException e) {
            throw new ContactException("Failed to delete contact", e);
        }
    }

    public Contact get(String id) {
        Contact organization;
        try {
            organization = contactDao.findOne(id);
        } catch (IllegalArgumentException e) {
            throw new ContactException("Failed to retrieve contact", e);
        }
        if (organization == null) {
            throw new ContactException("Contact not found");
        }
        return organization;
    }

    public Collection<Contact> getAll() {
        return contactDao.findAll();
    }

    public Collection<Contact> getAll(long offset, long limit) {
        throw new UnsupportedOperationException();
    }
}


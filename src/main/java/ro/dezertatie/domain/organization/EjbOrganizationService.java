package ro.dezertatie.domain.organization;


import org.apache.commons.lang.NullArgumentException;

import javax.inject.Inject;
import java.util.Collection;

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
}

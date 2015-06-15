package ro.dezertatie.domain.organization;


import org.apache.commons.lang.NullArgumentException;
import ro.dezertatie.domain.address.Address;
import ro.dezertatie.domain.address.AddressService;
import ro.dezertatie.domain.contact.Contact;
import ro.dezertatie.domain.contact.ContactService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collection;
import java.util.Set;

@Stateless
public class EjbOrganizationService implements OrganizationService {

	@Inject
	private OrganizationDao organizationDao;

	@Inject
	private OrganizationTypeDao organizationTypeDao;

	@Inject
	private AddressService addressService;

	@Inject
	private ContactService contactService;

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
		if (organizationTypeId == null) {
			throw new NullArgumentException("Null not allowed");
		}
		return organizationTypeDao.findOne(organizationTypeId);
	}

	@Override
	public Collection<OrganizationType> getAllOrganizationTypes() {
		return organizationTypeDao.findAll();
	}

	@Override
	public Address createAddress(String organizationId, Address address) {
		if (organizationId == null || address == null) {
			throw new NullArgumentException("Null not allowed");
		}

		Address persistedAddress = addressService.create(address);

		Organization organization = get(organizationId);
		if (organization == null) {
			throw new OrganizationException("Organization not found");
		}
		organization.getAddresses().add(persistedAddress);
		update(organization);

		return persistedAddress;
	}

	@Override
	public Address updateAddress(String organizationId, Address address) {
		if (organizationId == null || address == null) {
			throw new NullArgumentException("Null not allowed");
		}
		return addressService.update(address);
	}

	@Override
	public Collection<Address> getAddresses(String organizationId) {
		Organization organization = get(organizationId);
		Set<Address> addresses = organization.getAddresses();
		addresses.size();
		return addresses;
	}

	@Override
	public void deleteAddress(String organizationId, String addressId) {
		if (organizationId == null || addressId == null) {
			throw new NullArgumentException("Null not allowed");
		}
		Organization organization = get(organizationId);
		if (organization.getAddresses().remove(new Address(addressId))) {
			update(organization);
		}
	}

	@Override
	public Contact createContact(String organizationId, Contact contact) {
		if (organizationId == null || contact == null) {
			throw new NullArgumentException("Null not allowed");
		}
		Contact persistedContact = contactService.create(contact);
		Organization organization = get(organizationId);
		if (organization == null) {
			throw new OrganizationException("Organization not found");
		}
		organization.getContacts().add(persistedContact);
		update(organization);
		return contact;
	}

	@Override
	public Contact updateContact(String organizationId, Contact contact) {
		if (organizationId == null || contact == null) {
			throw new NullArgumentException("Null not allowed");
		}
		return contactService.update(contact);
	}

	@Override
	public Collection<Contact> getContacts(String organizationId) {
		Organization organization = get(organizationId);
		Set<Contact> contacts = organization.getContacts();
		contacts.size();
		return contacts;
	}

	@Override
	public void deleteContact(String organizationId, String contactId) {
		if (organizationId == null || contactId == null) {
			throw new NullArgumentException("Null not allowed");
		}
		Organization organization = get(organizationId);
		if (organization.getContacts().remove(new Contact(contactId))) {
			update(organization);
		}
	}
}

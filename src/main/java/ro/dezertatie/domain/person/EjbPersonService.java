package ro.dezertatie.domain.person;


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
public class EjbPersonService implements PersonService {

	@Inject
	private PersonDao personDao;

	@Inject
	private AddressService addressService;

	@Inject
	private ContactService contactService;

	@Override
	public Person create(Person entity) {
		return addOrUpdate(entity);
	}

	@Override
	public Person update(Person entity) {
		return addOrUpdate(entity);
	}

	private Person addOrUpdate(Person person) {
		if (person == null) {
			throw new NullArgumentException("Null not allowed.");
		}
		try {
			return personDao.save(person);
		} catch (IllegalArgumentException e) {
			throw new PersonException("Unable to persist entity.");
		}
	}

	@Override
	public void delete(Person entity) {
		if (entity == null) {
			throw new NullArgumentException("Null not allowed.");
		}
		deleteById(entity.getId());
	}

	@Override
	public void deleteById(String id) {
		if (id == null) {
			throw new NullArgumentException("Null not allowed.");
		}
		try {
			personDao.delete(id);
		} catch (IllegalArgumentException e) {
			throw new PersonException("Unable to delete entity.");
		}
	}

	@Override
	public Person get(String id) {
		if (id == null) {
			throw new NullArgumentException("Null not allowed.");
		}
		return personDao.findOne(id);
	}

	@Override
	public Collection<Person> getAll() {
		return personDao.findAll();
	}

	@Override
	public Collection<Person> getAll(long offset, long limit) {
		throw new UnsupportedOperationException("not implemented");
	}

	@Override
	public Address createAddress(String personId, Address address) {
		if (personId == null || address == null) {
			throw new NullArgumentException("Null not allowed");
		}

		Address persistedAddress = addressService.create(address);

		Person person = get(personId);
		if (person == null) {
			throw new PersonException("Person not found");
		}
		person.getAddresses().add(persistedAddress);
		update(person);

		return persistedAddress;
	}

	@Override
	public Collection<Address> getAddresses(String personId) {
		Person person = get(personId);
		Set<Address> addresses = person.getAddresses();
		addresses.size();
		return addresses;
	}

	@Override
	public Address updateAddress(String personId, Address address) {
		if (personId == null || address == null) {
			throw new NullArgumentException("Null not allowed");
		}
		return addressService.update(address);
	}

	@Override
	public void deleteAddress(String personId, String addressId) {
		if (personId == null || addressId == null) {
			throw new NullArgumentException("Null not allowed");
		}
		Person person = get(personId);
		if (person.getAddresses().remove(new Address(addressId))) {
			update(person);
		}
	}

	@Override
	public Contact createContact(String personId, Contact contact) {
		if (personId == null || contact == null) {
			throw new NullArgumentException("Null not allowed");
		}
		Contact persistedContact = contactService.create(contact);
		Person person = get(personId);
		if (person == null) {
			throw new PersonException("person not found");
		}
		person.getContacts().add(persistedContact);
		update(person);
		return contact;
	}

	@Override
	public Collection<Contact> getContacts(String personId) {
		Person person = get(personId);
		Set<Contact> contacts = person.getContacts();
		contacts.size();
		return contacts;
	}

	@Override
	public Contact updateContact(Long personId, Contact contact) {
		if (personId == null || contact == null) {
			throw new NullArgumentException("Null not allowed");
		}
		return contactService.update(contact);
	}

	@Override
	public void deleteContact(String personId, String contactId) {
		if (personId == null || contactId == null) {
			throw new NullArgumentException("Null not allowed");
		}
		Person person = get(personId);
		if (person.getContacts().remove(new Contact(contactId))) {
			update(person);
		}
	}
}

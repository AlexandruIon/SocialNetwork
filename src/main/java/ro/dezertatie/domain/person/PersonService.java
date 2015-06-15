package ro.dezertatie.domain.person;

import ro.dezertatie.common.service.CrudService;
import ro.dezertatie.domain.address.Address;
import ro.dezertatie.domain.contact.Contact;

import java.util.Collection;


public interface PersonService extends CrudService<Person, String, PersonException> {

	Address createAddress(String personId, Address address);

	Collection<Address> getAddresses(String personId);

	Address updateAddress(String personId, Address address);

	void deleteAddress(String personId, String addressId);

	Contact createContact(String personId, Contact contact);

	Collection<Contact> getContacts(String personId);

	Contact updateContact(Long personId, Contact contact);

	void deleteContact(String personId, String contactId);
}

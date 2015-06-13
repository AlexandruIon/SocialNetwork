package ro.dezertatie.domain.organization;


import ro.dezertatie.common.service.CrudService;
import ro.dezertatie.domain.address.Address;
import ro.dezertatie.domain.contact.Contact;

import java.util.Collection;

public interface OrganizationService extends CrudService<Organization, String, OrganizationException> {

    OrganizationType getOrganizationType(String organizationTypeId);

    Collection<OrganizationType> getAllOrganizationTypes();

    Address createAddress(String organizationId, Address address);

    Address updateAddress(String organizationId, Address address);

    Collection<Address> getAddresses(String organizationId);

    void deleteAddress(String organizationId, String addressId);

    Contact createContact(String organizationId, Contact contact);

    Contact updateContact(String organizationId, Contact contact);

    Collection<Contact> getContacts(String organizationId);

    void deleteContact(String organizationId, String contactId);

}

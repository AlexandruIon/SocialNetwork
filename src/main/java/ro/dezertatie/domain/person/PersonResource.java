package ro.dezertatie.domain.person;

import ro.dezertatie.domain.address.Address;
import ro.dezertatie.domain.address.AddressService;
import ro.dezertatie.domain.contact.Contact;
import ro.dezertatie.domain.contact.ContactService;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path(value = PersonResource.PATH)
public class PersonResource {

	public static final String PATH = "persons";
	public static final String ADDRESSES_PATH = "addresses";
	public static final String CONTACT = "contact";

	@Inject
	private PersonService personService;

	@Inject
	private AddressService addressService;

	@Inject
	private ContactService contactService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(Person person) {
		return Response.status(Response.Status.CREATED).entity(personService.create(person)).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Person> getAll() {
		return personService.getAll();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{personId}")
	public Person update(Person person) {
		return personService.update(person);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{personId}")
	public Person get(@PathParam("personId") String personId) {
		return personService.get(personId);
	}

	/**
	 * @param personId id of the person to remove.
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{personId}")
	public void remove(@PathParam("personId") String personId) {
		personService.deleteById(personId);
	}

	/**
	 * @param personId the id of the person
	 * @param address  the address to save
	 * @return addresses linked with the person; empty if no results are found
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{personId}/" + ADDRESSES_PATH)
	public Address saveAddress(@PathParam("personId") String personId, Address address) {
		return personService.createAddress(personId, address);
	}

	/**
	 * @param personId the id of the person
	 * @return addresses linked with the person; empty if no results are found
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{personId}/" + ADDRESSES_PATH)
	public Collection<Address> getAddresses(@PathParam("personId") String personId) {
		return personService.getAddresses(personId);
	}

	/**
	 * @param personId  the id of the person
	 * @param addressId the id of the address
	 * @return address linked with the person with the given addressId;
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{personId}/" + ADDRESSES_PATH + "/{addressId}")
	public Address getAddress(@PathParam("personId") String personId, @PathParam("addressId") String addressId) {
		return addressService.get(addressId);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{personId}/" + ADDRESSES_PATH + "/{addressId}")
	public Address updateAddress(@PathParam("personId") String personId, @PathParam("addressId") String addressId, Address address) {
		return personService.updateAddress(personId, address);
	}

	/**
	 * deletes a given address and the link to an person
	 *
	 * @param personId  id of the person
	 * @param addressId id of the address to delete
	 * @return the base response
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{personId}/" + ADDRESSES_PATH + "/{addressId}")
	public void deleteAddress(@PathParam("personId") String personId, @PathParam("addressId") String addressId) {
		personService.deleteAddress(personId, addressId);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{personId}/" + CONTACT)
	public Contact saveContact(@PathParam("personId") String personId, Contact contact) {
		return personService.createContact(personId, contact);
	}


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{personId}/" + CONTACT)
	public Collection<Contact> getContacts(@PathParam("personId") String personId) {
		return personService.getContacts(personId);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{personId}/" + CONTACT + "/{contactId}")
	public Contact getContact(@PathParam("personId") String personId, @PathParam("contactId") String contactId) {
		return contactService.get(contactId);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{personId}/" + CONTACT + "/{contactId}")
	public Contact updateContact(@PathParam("personId") Long personId, @PathParam("contactId") Long contactId, Contact contact) {
		return personService.updateContact(personId, contact);
	}


	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{personId}/" + CONTACT + "/{contactId}")
	public void deleteContact(@PathParam("personId") String personId, @PathParam("contactId") String contactId) {
		personService.deleteContact(personId, contactId);
	}
}

package ro.dezertatie.domain.organization;

import ro.dezertatie.domain.address.Address;
import ro.dezertatie.domain.address.AddressService;
import ro.dezertatie.domain.contact.Contact;
import ro.dezertatie.domain.contact.ContactService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path(value = OrganizationResource.PATH)
public class OrganizationResource {

    public static final String PATH = "organization";
    public static final String TYPES_PATH = "types";
    public static final String ADDRESSES_PATH = "addresses";
    public static final String CONTACT = "contact";

    @Inject
    private OrganizationService organizationService;

    @Inject
    private AddressService addressService;

    @Inject
    private ContactService contactService;

    /**
     * @param organizationId id of the organization to retrieve
     * @return the organization if found, otherwise an error will be issued
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{organizationId}")
    public Organization get(@PathParam("organizationId") String organizationId) {
        return organizationService.get(organizationId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Organization> getAll() {
        return organizationService.getAll();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Organization organization) {
        return Response.status(Response.Status.CREATED).entity(organizationService.create(organization)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{organizationId}")
    public Organization update(@PathParam("organizationId") Long organizationId, Organization organization) {
        return organizationService.update(organization);
    }

    /**
     * @param organizationTypeId id of an organization type
     * @return the type if found, otherwise an error will be issued
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/" + TYPES_PATH + "/{organizationTypeId}")
    public OrganizationType getOrganizationType(@PathParam("organizationTypeId") String organizationTypeId) {
        return organizationService.getOrganizationType(organizationTypeId);
    }

    /**
     * @return all organization types
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/" + TYPES_PATH)
    public Collection<OrganizationType> getAllOrganizationTypes() {
        return organizationService.getAllOrganizationTypes();
    }


    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{organizationId}")
    public void remove(@PathParam("organizationId") String organizationId) {
        organizationService.deleteById(organizationId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{organizationId}/" + ADDRESSES_PATH)
    public Response saveAddress(@PathParam("organizationId") String organizationId, Address address) {
        return Response.status(Response.Status.CREATED).entity(organizationService.createAddress(organizationId, address)).build();
    }

    /**
     * Updates an address of an organization
     *
     * @param organizationId id of the organization
     * @param address        the address to save
     * @return the organization which holds the saved address
     */
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{organizationId}/" + ADDRESSES_PATH + "/{addressId}")
    public Address updateAddress(@PathParam("organizationId") String organizationId, @PathParam("addressId") String addressId, Address address) {
        return organizationService.updateAddress(organizationId, address);
    }

    /**
     * Retrieves the addresses of an organization
     *
     * @param organizationId id of the organization
     * @return the collection of addresses belonging to the organization
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{organizationId}/" + ADDRESSES_PATH)
    public Collection<Address> getAddresses(@PathParam("organizationId") String organizationId) {
        return organizationService.getAddresses(organizationId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{personId}/" + ADDRESSES_PATH + "/{addressId}")
    public Address getAddress(@PathParam("personId") Long personId, @PathParam("addressId") String addressId) {
        return addressService.get(addressId);
    }

    /**
     * Removes an address of an organization
     *
     * @param organizationId id of the organization
     * @param addressId      id of the address to remove
     */
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{organizationId}/" + ADDRESSES_PATH + "/{addressId}")
    public void removeAddress(@PathParam("organizationId") String organizationId, @PathParam("addressId") String addressId) {
        organizationService.deleteAddress(organizationId, addressId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{organizationId}/" + CONTACT)
    public Response saveContact(@PathParam("organizationId") String organizationId, Contact contact) {
        organizationService.createContact(organizationId, contact);
        return Response.status(Response.Status.CREATED).entity(contact).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{organizationId}/" + CONTACT + "/{contactId}")
    public Contact updateContact(@PathParam("organizationId") String organizationId, @PathParam("contactId") Long contactId, Contact contact) {
        return organizationService.updateContact(organizationId, contact);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{organizationId}/" + CONTACT)
    public Collection<Contact> getContacts(@PathParam("organizationId") String organizationId) {
        return organizationService.getContacts(organizationId);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{organizationId}/" + CONTACT + "/{contactId}")
    public Contact getContact(@PathParam("organizationId") String organizationId, @PathParam("contactId") String contactId) {
        return contactService.get(contactId);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{organizationId}/" + CONTACT + "/{contactId}")
    public void deleteContact(@PathParam("organizationId") String organizationId, @PathParam("contactId") String contactId) {
        organizationService.deleteContact(organizationId, contactId);
    }


}

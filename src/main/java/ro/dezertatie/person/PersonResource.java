package ro.dezertatie.person;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path(value = PersonResource.PATH)
public class PersonResource {

	public static final String PATH = "person";

	@Inject
	private PersonService personService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Person create(Person person) {
		return personService.create(person);
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
		Person personFound = personService.get(person.getId());
		if (personFound == null) {
			throw new PersonException("Person not found");
		}
		return personService.update(person);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{personId}")
	public void delete(@PathParam("personId") String personId) {
		personService.deleteById(personId);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{personId}")
	public Person get(@PathParam("personId") String personId) {
		return personService.get(personId);
	}

}

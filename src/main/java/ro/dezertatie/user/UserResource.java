package ro.dezertatie.user;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path(UserResource.PATH)
public class UserResource {

	public static final String PATH = "users";

	@Inject
	private UserService userService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public User createUser(User user) {
		return userService.create(user);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<User> getUsers() {
		return userService.getAll();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{userId }")
	public User update(User user) {
		User userFound = userService.get(user.getId());
		if (userFound == null) {
			throw new UserException("User not found");
		}
		return userService.update(user);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{userId}")
	public void deleteUser(@PathParam("userId") String userId) {
		userService.deleteById(userId);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{userId}")
	public User getUser(@PathParam("userId") String userId) {
		return userService.get(userId);
	}
}

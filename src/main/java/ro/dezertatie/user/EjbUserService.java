package ro.dezertatie.user;

import org.apache.commons.lang.NullArgumentException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collection;

@Stateless
public class EjbUserService implements UserService {

	@Inject
	private UserDao userDao;

	public User create(User entity) {
		return createOrUpdate(entity);
	}

	public User update(User entity) {
		return createOrUpdate(entity);
	}

	private User createOrUpdate(User entity) {
		if (entity == null) {
			throw new NullArgumentException("Null not allowed");
		}
		try {
			return userDao.save(entity);
		} catch (IllegalArgumentException e) {
			throw new UserException("Failed to persist user", e);
		}
	}


	public void delete(User entity) {
		if (entity == null) {
			throw new NullArgumentException("Null not allowed");
		}
		deleteById(entity.getId());
	}

	public void deleteById(Long id) {
		try {
			userDao.delete(id);
		} catch (IllegalArgumentException e) {
			throw new UserException("Failed to delete user", e);
		}
	}

	public User get(Long id) {
		User user;
		try {
			user = userDao.findOne(id);
		} catch (IllegalArgumentException e) {
			throw new UserException("Failed to retrieve user", e);
		}
		if (user == null) {
			throw new UserException("User not found");
		}
		return user;
	}

	public Collection<User> getAll() {
		return userDao.findAll();
	}

	public Collection<User> getAll(long offset, long limit) {
		throw new UnsupportedOperationException();
	}
}

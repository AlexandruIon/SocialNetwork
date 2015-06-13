package ro.dezertatie.domain.person;


import org.apache.commons.lang.NullArgumentException;

import javax.inject.Inject;
import java.util.Collection;

public class EjbPersonService implements PersonService {

	@Inject
	private PersonDao personDao;

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
}

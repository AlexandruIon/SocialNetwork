package ro.dezertatie.user;


import ro.dezertatie.common.domain.BaseEntity;
import ro.dezertatie.person.Person;

public class User extends BaseEntity<Long> {

	private String username;
	private String password;
	private Boolean enabled = Boolean.TRUE;
	private Person person;

	public User(Long Id, String username, String password) {
		super(Id);
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}

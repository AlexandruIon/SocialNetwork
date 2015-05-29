package ro.dezertatie.user;


import ro.dezertatie.common.domain.BaseEntity;
import ro.dezertatie.person.Person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users", schema = "dezertatie@mongo-pu")
public class User extends BaseEntity<String> {

	private static final long serialVersionUID = 1L;


	@Column(name = "column")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "enabled")
	private Boolean enabled = Boolean.TRUE;
	@Column(name = "person_id")
	private Person person;

	public User() {
	}

	public User(String Id, String username, String password) {
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

	@OneToOne

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}

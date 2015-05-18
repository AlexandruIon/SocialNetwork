package ro.dezertatie.user;


import ro.dezertatie.common.domain.BaseEntity;
import ro.dezertatie.person.Person;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private Boolean enabled = Boolean.TRUE;
	private Person person;

	public User(Long Id, String username, String password) {
		super(Id);
		this.username = username;
		this.password = password;
	}

	@Column(name = "column")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "enabled")
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name = "person_id")
	@JoinTable(name = "person",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "person_id"))
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}

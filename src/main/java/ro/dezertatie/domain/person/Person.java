package ro.dezertatie.domain.person;

import org.apache.commons.lang.builder.ToStringBuilder;
import ro.dezertatie.common.domain.BaseEntity;

import javax.persistence.Column;
import java.util.Date;

public class Person extends BaseEntity<String> {

	private static final long serialVersionUID = 1L;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date birthDate;

	public Person() {
	}

	public Person(String firstName, String middleName, String lastName, Date birthDate) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public Person(String Id, String firstName, String middleName, String lastName, Date birthDate) {
		super(Id);
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "middle_name")
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "birth_date")
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("First name", firstName)
				.append("middle name", middleName)
				.append("last name", lastName)
				.append("birth date", birthDate)
				.toString();
	}
}

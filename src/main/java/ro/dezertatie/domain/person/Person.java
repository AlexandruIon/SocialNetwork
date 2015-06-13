package ro.dezertatie.domain.person;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnore;
import ro.dezertatie.common.domain.BaseEntity;
import ro.dezertatie.domain.address.Address;
import ro.dezertatie.domain.contact.Contact;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

public class Person extends BaseEntity<String> {

    private static final long serialVersionUID = 1L;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;
    private Set<Address> addresses;
    private Set<Contact> contacts;
    private PersonType personType;

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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "rel_person_address",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id", unique = true))
    @JsonIgnore
    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "rel_person_contact",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_id", unique = true)
    )
    @JsonIgnore
    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    @ManyToOne
    @Column(name = "person_type_id")
    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
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

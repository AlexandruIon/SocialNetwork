package ro.dezertatie.domain.contact;

import org.apache.commons.lang.builder.ToStringBuilder;
import ro.dezertatie.common.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Contact extends BaseEntity<String> {

    private static final long serialVersionUID = 1L;

    private String name;
    private String phoneNumber;
    private String faxNumber;
    private String email;
    private ContactType contactType;

    public Contact() {
    }

    public Contact(String id) {
        super(id);
    }

    public Contact(String name, String phoneNumber, String faxNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToOne
    @Column(name = "contact_type_id", nullable = false)
    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("phoneNumber", phoneNumber)
                .append("faxNumber", faxNumber)
                .append("email", email)
                .append("contactType", contactType)
                .toString();
    }
}

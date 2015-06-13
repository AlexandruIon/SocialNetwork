package ro.dezertatie.domain.address;


import org.apache.commons.lang.builder.ToStringBuilder;
import ro.dezertatie.common.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Address extends BaseEntity<String> {

    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private AddressType type;

    public Address() {
    }

    public Address(String Id) {
        super(Id);
    }

    public Address(String street, String city, String state, String country, String zipCode, AddressType type) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.type = type;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @ManyToOne
    @Column(name = "address_type_id", nullable = false)
    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("street", street)
                .append("city", city)
                .append("state", state)
                .append("country", country)
                .append("zipCode", zipCode)
                .append("type", type)
                .toString();
    }
}

package ro.dezertatie.domain.organization;

import org.apache.commons.lang.builder.ToStringBuilder;
import ro.dezertatie.common.domain.BaseEntity;
import ro.dezertatie.domain.address.Address;
import ro.dezertatie.domain.contact.Contact;
import ro.dezertatie.domain.product.Product;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Organization extends BaseEntity<String> {

    private static final long serialVersionUID = 1L;

    private String name;
    private OrganizationType type;
    private Set<Address> addresses;
    private Set<Contact> contacts;
    private Collection<Product> products;

    public Organization() {
    }

    public Organization(String Id) {
        super(Id);
    }

    public Organization(String name, OrganizationType type, Set<Address> addresses, Set<Contact> contacts, Collection<Product> products) {
        this.name = name;
        this.type = type;
        this.addresses = addresses;
        this.contacts = contacts;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany
    @Column(name = "organization_type_id", nullable = false)
    public OrganizationType getType() {
        return type;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "rel_organization_address",
            joinColumns = @JoinColumn(name = "organization_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "rel_organization_contacts",
            joinColumns = @JoinColumn(name = "organization_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_id")
    )
    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "rel_organization_product",
            joinColumns = @JoinColumn(name = "organization_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("type", type)
                .append("addresses", addresses)
                .append("contacts", contacts)
                .toString();
    }

}

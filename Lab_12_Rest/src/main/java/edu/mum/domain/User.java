package edu.mum.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import edu.mum.validation.EmptyOrSize;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "USERS")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Long id = null;

	@Version
	private int version = 0;

	@Column(name = "FIRSTNAME", nullable = false)
	@EmptyOrSize(min = 4, max = 19, message = "{Size.name.validation}")
	private String firstName;

	@Column(name = "LASTNAME", nullable = false)
	@NotEmpty(message = "{NotEmpty}")
	private String lastName;

	@Column(name = "EMAIL", nullable = false)
	@NotEmpty(message = "{email}")
	private String email;

	@Column(name = "RANKING", nullable = false)
	private Integer rating = 0;

	@Column(name = "IS_ADMIN", nullable = false)
	private boolean admin = false;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private UserCredentials userCredentials;
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user")
	private List<Address> addresses = new ArrayList<Address>();

	/*
	 * @OneToMany(mappedBy = "seller") private Collection<Item> itemsForSale = new
	 * ArrayList<Item>();
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Item> boughtItems = new HashSet<Item>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public UserCredentials getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<Item> getBoughtItems() {
		return boughtItems;
	}

	public void setBoughtItems(Set<Item> boughtItems) {
		this.boughtItems = boughtItems;
	}

	public void addBoughtItem(Item boughtItem) {
		this.boughtItems.add(boughtItem);
	}

	public void addAddress(Address address) {
		this.addresses.add(address);
		address.setUser(this);
	}
}
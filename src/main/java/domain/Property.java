
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Property extends DomainEntity {

	// Attributes
	// ====================================================================================

	private String	name;
	private Double	rate;
	private String	description;
	private String	address;
	private int		bookCount;


	// Constructors
	// ====================================================================================

	public Property() {
		super();
	}

	// Getters & setters
	// ====================================================================================

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	@Digits(integer = 12, fraction = 2)
	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	@NotBlank
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@NotBlank
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Min(0)
	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}


	// Relationships
	// ====================================================================================

	private Lessor						lessor;
	private Collection<AttributeValue>	attributeValues;
	private Collection<Audit>			audits;
	private Collection<Booking>			bookings;


	@NotNull
	@Valid
	@ManyToOne(optional = false)
	public Lessor getLessor() {
		return lessor;
	}

	public void setLessor(Lessor lessor) {
		this.lessor = lessor;
	}

	@Valid
	@OneToMany(mappedBy = "property")
	public Collection<AttributeValue> getAttributeValues() {
		return attributeValues;
	}

	public void setAttributeValues(Collection<AttributeValue> attributeValues) {
		this.attributeValues = attributeValues;
	}

	@Valid
	@OneToMany(mappedBy = "property")
	public Collection<Audit> getAudits() {
		return audits;
	}

	public void setAudits(Collection<Audit> audits) {
		this.audits = audits;
	}

	@Valid
	@OneToMany
	public Collection<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Collection<Booking> bookings) {
		this.bookings = bookings;
	}
}

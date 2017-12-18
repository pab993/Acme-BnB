
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class Tenant extends Customer {

	// Attributes
	// ====================================================================================

	// Constructors
	// ====================================================================================

	public Tenant() {
		super();
	}


	// Relationships
	// ====================================================================================

	private Finder				finder;
	private Collection<Booking>	bookings;


	@Valid
	@OneToMany(mappedBy = "tenant")
	public Collection<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Collection<Booking> bookings) {
		this.bookings = bookings;
	}

	@Valid
	@OneToOne(optional = true, cascade = CascadeType.ALL)
	public Finder getFinder() {
		return finder;
	}

	public void setFinder(Finder finder) {
		this.finder = finder;
	}
}

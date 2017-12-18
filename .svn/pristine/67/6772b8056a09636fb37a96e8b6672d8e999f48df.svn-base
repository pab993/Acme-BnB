
package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Finder extends DomainEntity {

	// Attributes
	// ====================================================================================

	private String	destination;
	private Double	minPrice;
	private Double	maxPrice;
	private String	keyword;
	private Date	searchMoment;


	// Constructors
	// ====================================================================================

	public Finder() {
		super();
	}

	// Getters & setters
	// ====================================================================================

	@NotBlank
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Digits(integer = 12, fraction = 2)
	public Double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}

	@Digits(integer = 12, fraction = 2)
	public Double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Past
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getSearchMoment() {
		return searchMoment;
	}

	public void setSearchMoment(Date searchMoment) {
		this.searchMoment = searchMoment;
	}


	// Relationships
	// ====================================================================================

	private Tenant					tenant;
	private Collection<Property>	results;


	@Valid
	@OneToOne(optional = false)
	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	@Valid
	@ManyToMany
	public Collection<Property> getResults() {
		return results;
	}

	public void setResults(Collection<Property> results) {
		this.results = results;
	}

}

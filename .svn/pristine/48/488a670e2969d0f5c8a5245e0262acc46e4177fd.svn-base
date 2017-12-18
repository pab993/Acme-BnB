
package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Lessor extends Customer {

	// Attributes
	// ====================================================================================

	private CreditCard	creditCard;
	private Double		amount;


	// Constructors
	// ====================================================================================

	public Lessor() {
		super();
	}

	// Getters & setters
	// ====================================================================================

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	@Digits(integer = 12, fraction = 2)
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}


	// Relationship
	// ====================================================================================

	private Collection<Property>	properties;


	@Valid
	@OneToMany(mappedBy = "lessor")
	public Collection<Property> getProperties() {
		return properties;
	}

	public void setProperties(Collection<Property> properties) {
		this.properties = properties;
	}

}

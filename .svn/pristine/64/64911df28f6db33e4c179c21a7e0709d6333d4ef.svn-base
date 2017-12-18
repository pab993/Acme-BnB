
package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Access(AccessType.PROPERTY)
@Entity
public class Invoice extends DomainEntity {

	// Attributes
	// ====================================================================================

	private Date	createMoment;
	private String	vatNumber;
	private String	information;
	private String	details;
	private Double	amount;


	// Constructors
	// ====================================================================================

	public Invoice() {
		super();
	}

	// Getters & Setters
	// ====================================================================================

	@Past
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateMoment() {
		return createMoment;
	}

	public void setCreateMoment(Date createMoment) {
		this.createMoment = createMoment;
	}

	@NotBlank
	@Pattern(regexp = "ACME\\d{9}")
	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	@NotBlank
	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	@NotBlank
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@NotNull
	@Digits(fraction = 2, integer = 12)
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}

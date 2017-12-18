
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Auditor extends Actor {

	// Attributes
	// ====================================================================================

	private String	company;


	// Constructor
	// ====================================================================================

	public Auditor() {
		super();
	}

	// Getters & setters
	// ====================================================================================

	@NotBlank
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}


	// Relationships
	// ====================================================================================

	private Collection<Audit>	audits;


	@Valid
	@OneToMany(mappedBy = "auditor")
	public Collection<Audit> getAudits() {
		return audits;
	}

	public void setAudits(Collection<Audit> audits) {
		this.audits = audits;
	}

}

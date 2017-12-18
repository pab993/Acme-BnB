
package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Audit extends DomainEntity {

	// Attributes
	// ====================================================================================

	private Date				createMoment;
	private String				text;
	private Collection<String>	attachments;
	private Boolean				draft;


	// Constructor
	// ====================================================================================

	public Audit() {
		super();
	}

	// Getters & setters
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	@URL.List(value = {})
	@ElementCollection
	public Collection<String> getAttachments() {
		return attachments;
	}
	public void setAttachments(Collection<String> attachments) {
		this.attachments = attachments;
	}

	public Boolean getDraft() {
		return draft;
	}

	public void setDraft(Boolean draft) {
		this.draft = draft;
	}


	// RelationShips 
	// ====================================================================================

	private Auditor		auditor;
	private Property	property;


	@Valid
	@NotNull
	@ManyToOne(optional = false)
	public Auditor getAuditor() {
		return auditor;
	}

	public void setAuditor(Auditor auditor) {
		this.auditor = auditor;
	}

	@Valid
	@NotNull
	@ManyToOne(optional = false)
	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}
}

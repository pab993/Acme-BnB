
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class AttributeValue extends DomainEntity {

	// Attributes 
	// ====================================================================================

	private String	value;


	// Constructors 
	// ====================================================================================

	public AttributeValue() {
		super();
	}

	// Getters & setters 
	// ====================================================================================

	@NotBlank
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}


	// Relationships 
	// ====================================================================================

	private AttributeName	attributeName;
	private Property		property;


	@Valid
	@NotNull
	@ManyToOne(optional = false)
	public AttributeName getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(AttributeName attributeName) {
		this.attributeName = attributeName;
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

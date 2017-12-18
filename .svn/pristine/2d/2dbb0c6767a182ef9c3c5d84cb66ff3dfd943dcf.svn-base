
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
public class AttributeName extends DomainEntity {

	// Attributes 
	// ====================================================================================

	private String	name;


	// Constructors 
	// ====================================================================================

	public AttributeName() {
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


	// Relationships 
	// ====================================================================================

	private Collection<AttributeValue>	attributeValues;


	@Valid
	@OneToMany(mappedBy = "attributeName")
	public Collection<AttributeValue> getAttributeValues() {
		return attributeValues;
	}

	public void setAttributeValues(Collection<AttributeValue> attributeValues) {
		this.attributeValues = attributeValues;
	}

}

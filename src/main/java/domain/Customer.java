
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public abstract class Customer extends Actor {

	// Attributes
	// ====================================================================================

	// Constructors
	// ====================================================================================

	public Customer() {
		super();
	}


	// Getters & setters
	// ====================================================================================

	// Relationships
	// ====================================================================================

	private Collection<Comment>	writeComments;


	@Valid
	@OneToMany(mappedBy = "customer")
	public Collection<Comment> getWriteComments() {
		return writeComments;
	}

	public void setWriteComments(Collection<Comment> writeComments) {
		this.writeComments = writeComments;
	}
}

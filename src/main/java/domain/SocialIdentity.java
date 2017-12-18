
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class SocialIdentity extends DomainEntity {

	// Attributes
	// ====================================================================================

	private String	nick;
	private String	network;
	private String	url;


	// Constructors
	// ====================================================================================

	public SocialIdentity() {
		super();
	}

	// Getters & Setters
	// ====================================================================================

	@NotBlank
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@NotBlank
	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	@NotBlank
	@URL
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	// Relationships
	// ====================================================================================

	private Actor	actor;


	@Valid
	@ManyToOne(optional = false)
	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

}

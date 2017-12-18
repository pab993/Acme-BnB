
package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Comment extends DomainEntity {

	// Attributes
	// ====================================================================================

	private String	title;
	private Date	createMoment;
	private String	text;
	private int		stars;


	// Constructors
	// ====================================================================================

	public Comment() {
		super();
	}

	// Getters & setters
	// ====================================================================================

	@NotBlank
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

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

	@Range(min = 0, max = 5)
	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}


	// Relationships
	// ====================================================================================

	private Customer	customer;
	private Comentable	comentable;

	@Valid
	@ManyToOne(optional = false)
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Valid
	@ManyToOne(optional = false)
	public Comentable getComentable() {
		return comentable;
	}

	public void setComentable(Comentable comentable) {
		this.comentable = comentable;
	}

}

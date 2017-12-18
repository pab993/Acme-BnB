
package forms;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public class AuditorForm {

	public AuditorForm() {
		super();
	}


	private String	username;
	private String	password;
	private String	repeatPassword;
	private String	name;
	private String	surname;
	private String	phone;
	private String	email;
	private String	picture;
	private String	company;


	@Column(unique = true)
	@Size(min = 5, max = 32)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Size(min = 5, max = 32)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Size(min = 5, max = 32)
	public String getRepeatPassword() {
		return repeatPassword;
	}
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	@NotBlank
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@NotBlank
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Pattern(regexp = "^[(][+][0-9]{2,3}[)][0-9]{9}$")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@NotBlank
	@URL
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Email
	@NotBlank
	@Column(unique = true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@NotBlank
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}

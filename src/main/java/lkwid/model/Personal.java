package lkwid.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

/**
 * @author lkwid
 *
 */

public class Personal {
	@Size(min=2)
	private String name;
	@Size(min=2)
	private String surname;
	@NotBlank
	private String address;
	@NotBlank
	private String birthdate;
	@NotBlank
	private String phone;
	@Email
	@NotEmpty
	private String email;
	@URL
	private String link;	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phoneNo) {
		this.phone = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}	
}

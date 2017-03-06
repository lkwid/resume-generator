package lkwid.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author lkwid
 *
 */

public class Personal {	
	private String name;
	private String surname;
	private String address;
	private LocalDate birthdate;
	private String phone;
	private String email;
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
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String text, LocalDate birthdate) {
		this.birthdate = birthdate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
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

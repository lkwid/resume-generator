package lkwid.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class FormSession implements Serializable {
	private String name;
	private String surname;
	private String address;
	private LocalDate birthdate;
	private String phone;
	private String email;
	private String link;
	private List<String> skills = new ArrayList<>();
	private List<YearMonth> courseDates = new ArrayList<>();
	private List<String> courseDescriptions = new ArrayList<>();
	
	public void savePersonal(Personal personal) {
		this.name = personal.getName();
		this.surname = personal.getSurname();
		this.address = personal.getAddress();
		this.birthdate = personal.getBirthdate();
		this.phone = personal.getPhone();
		this.email = personal.getEmail();
		this.link = personal.getLink();
	}
	
	public void saveSkill(Skill skill) {
		this.skills = skill.getSkills();
	}
	
	public void saveEducation(Education education) {
		this.courseDates = education.getCourseDates();
		this.courseDescriptions = education.getCourseDescriptions();
	}
	
	public Personal toPersonal() {
		Personal personal = new Personal();
		personal.setName(name);
		personal.setSurname(surname);
		personal.setAddress(address);
//		personal.setBirthdate(null, birthdate);
		personal.setPhone(phone);
		personal.setEmail(email);
		personal.setLink(link);
		return personal;
	}
	
	public Skill toSkills() {
		Skill skill = new Skill();
		skill.setSkills(skills);
		return skill;
	}
	
	public Education toEducation() {
		Education education = new Education();
		education.setCourseDates(courseDates);
		education.setCourseDescriptions(courseDescriptions);
		return education;
	}	

}

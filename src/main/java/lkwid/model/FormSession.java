package lkwid.model;

import java.io.Serializable;
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
	private String birthdate;
	private String phone;
	private String email;
	private String link;
	private List<String> skills = new ArrayList<>();
	private List<YearMonth> courseDates = new ArrayList<>();
	private List<String> courseDescriptions = new ArrayList<>();
	private List<YearMonth> startExperience = new ArrayList<>();
	private List<YearMonth> stopExperience = new ArrayList<>();
	private List<String> jobDescriptions = new ArrayList<>();
	private List<String> languages = new ArrayList<>();
	private List<String> proficiency = new ArrayList<>();	
	private List<String> drivingLicenceCategory = new ArrayList<>();
	private List<String> talents = new ArrayList<>();
	private List<String> interests = new ArrayList<>();

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

	public void saveExperience(Experience experience) {
		this.startExperience = experience.getStartExperience();
		this.stopExperience = experience.getStopExperience();
		this.jobDescriptions = experience.getJobDescriptions();
	}
	
	public void saveCompetence(Competence competence) {
		this.languages = competence.getLanguages();
		this.proficiency = competence.getProficiency();
		this.drivingLicenceCategory = competence.getDrivingLicenceCategory(); 
		this.talents = competence.getPerks();
	}
	
	public void saveInterest(Interest interest) {
		this.interests = interest.getInterests();
	}
	
	public Personal toPersonal() {
		Personal personal = new Personal();
		personal.setName(name);
		personal.setSurname(surname);
		personal.setAddress(address);
		personal.setBirthdate(birthdate);
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

	public Experience toExperience() {
		Experience experience = new Experience();
		experience.setStartExperience(startExperience);
		experience.setStopExperience(stopExperience);
		experience.setJobDescriptions(jobDescriptions);
		return experience;
	}
	
	public Competence toCompetence() {
		Competence competence = new Competence();
		competence.setLanguages(languages);
		competence.setProficiency(proficiency);
		competence.setDrivingLicenceCategory(drivingLicenceCategory);
		competence.setPerks(talents);
		return competence;
	}
	
	public Interest toInterest() {
		Interest interest = new Interest();
		interest.setInterests(interests);
		return interest;
	}

}

package lkwid.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lkwid.model.Competence;
import lkwid.model.Education;
import lkwid.model.Experience;
import lkwid.model.FormSession;
import lkwid.model.Interest;
import lkwid.model.Personal;
import lkwid.model.Skill;

@Controller
public class ResumeController {
	private FormSession formSession;

	@Autowired
	public ResumeController(FormSession formSession) {
		this.formSession = formSession;
	}

	@ModelAttribute
	public Personal getPersonal() {
		return formSession.toPersonal();
	}

	@ModelAttribute
	public Skill getSkill() {
		return formSession.toSkills();
	}

	@ModelAttribute
	public Education getEducation() {
		return formSession.toEducation();
	}
	
	@ModelAttribute
	public Experience getExperience() {
		return formSession.toExperience();
	}
	
	@ModelAttribute
	public Competence getCompetence() {
		return formSession.toCompetence();
	}
	
	@ModelAttribute
	public Interest getInterest() {
		return formSession.toInterest();
	}

	@RequestMapping("/personal")
	public String formPersonal() {		
		return "/form/personal";
	}

	@PostMapping(value = "/personal", params = { "save" })
	public String addPersonal(Personal personal, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "/new";
		formSession.savePersonal(personal);
		return "redirect:/skill";		
	}

	@RequestMapping("/skill")
	public String formSkills() {
		return "/form/skill";
	}

	@PostMapping(value = "/skill", params = { "save" })
	public String addSkills(Skill skill, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "/new";
		formSession.saveSkill(skill);
		return "redirect:/education";
	}

	@RequestMapping("/education")
	public String formEducation() {
		return "/form/education";
	}

	@PostMapping(value = "/education", params = { "save" })
	public String addEducation(Education education, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "/new";
		formSession.saveEducation(education);
		return "redirect:/experience";
	}
	
	@RequestMapping("/experience")
	public String formExperience() {
		return "/form/experience";
	}
	
	@PostMapping(value = "/experience", params = { "save" })
	public String addExperience(Experience experience, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "/new";
		formSession.saveExperience(experience);
		return "redirect:/competence";
	}
	
	@RequestMapping("/competence")
	public String formCompetence() {
		return "/form/competence";
	}
	
	@PostMapping(value = "/competence", params = { "save" })
	public String addCompetence(Competence competence, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "/new";
		formSession.saveCompetence(competence);
		return "redirect:/interest";
	}
	
	@RequestMapping("/interest")
	public String formInterest() {
		return "/form/interest";
	}
	
	@PostMapping(value = "/interest", params = { "save" })
	public String addInterest(Interest interest, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "/interest";
		formSession.saveInterest(interest);
		return "/resume";
	}

	@RequestMapping(value = "/skill", params = { "addSkill" })
	public String addSkill(Skill skill) {
		skill.getSkills().add(null);
		return "/form/skill";
	}

	@RequestMapping(value = "/skill", params = { "removeSkill" })
	public String removeSkill(Skill skill, HttpServletRequest req) {
		Integer rowId = Integer.valueOf(req.getParameter("removeSkill"));
		skill.getSkills().remove(rowId.intValue());
		return "/form/skill";
	}
	
	@RequestMapping(value = "/education", params = { "addCourse" })
	public String addCourse(Education education) {
		education.getCourseDates().add(null);
		education.getCourseDescriptions().add(null);
		return "/form/education";
	}

	@RequestMapping(value = "/education", params = { "removeCourse" })
	public String removeCourse(Education education, HttpServletRequest req) {
		Integer rowId = Integer.valueOf(req.getParameter("removeCourse"));
		education.getCourseDates().remove(rowId.intValue());
		education.getCourseDescriptions().remove(rowId.intValue());
		return "/form/education";
	}
	
	@RequestMapping(value = "/experience", params = { "addExperience" })
	public String addExperience(Experience experience) {
		experience.getStartExperience().add(null);
		experience.getStopExperience().add(null);
		experience.getJobDescriptions().add(null);
		return "/form/experience";
	}
	
	@RequestMapping(value = "/experience", params = { "removeExperience" })
	public String removeExperience(Experience experience, HttpServletRequest req) {
		Integer rowId = Integer.valueOf(req.getParameter("removeExperience"));
		experience.getStartExperience().remove(rowId.intValue());
		experience.getStopExperience().remove(rowId.intValue());
		experience.getJobDescriptions().remove(rowId.intValue());
		return "/form/experience";
	}
	
	@RequestMapping(value = "/competence", params = { "addLanguage" })
	public String addLanguages(Competence competence) {
		competence.getLanguages().add(null);
		competence.getProficiency().add(null);		
		return "/form/competence";
	}
	
	@RequestMapping(value = "/competence", params = { "removeLanguage" })
	public String removeLanguages(Competence competence, HttpServletRequest req) {
		Integer rowId = Integer.valueOf(req.getParameter("removeLanguages"));
		competence.getLanguages().remove(rowId.intValue());		
		return "/form/competence";
	}
	
	@RequestMapping(value = "/competence", params = { "addDrivingLicence" })
	public String addDrivingLicence(Competence competence) {		
		competence.getDrivingLicenceCategory().add(null);
		return "/form/competence";
	}
	
	@RequestMapping(value = "/competence", params = { "removeDrivingLicence" })
	public String removeDrivingLicence(Competence competence, HttpServletRequest req) {
		Integer rowId = Integer.valueOf(req.getParameter("removeDrivingLicence"));
		competence.getDrivingLicenceCategory().remove(rowId.intValue());		
		return "/form/competence";
	}
	
	@RequestMapping(value = "/competence", params = { "addPerk" })
	public String addPerks(Competence competence) {		
		competence.getPerks().add(null);
		return "/form/competence";
	}
	
	@RequestMapping(value = "/competence", params = { "removePerk" })
	public String removePerks(Competence competence, HttpServletRequest req) {
		Integer rowId = Integer.valueOf(req.getParameter("removePerks"));
		competence.getPerks().remove(rowId.intValue());		
		return "/form/competence";
	}
	
	@RequestMapping(value = "/interest", params = { "addInterest" })
	public String addInterests (Interest interest) {		
		interest.getInterests().add(null);
		return "/form/interest";
	}	
	
	@RequestMapping(value = "/interest", params = { "removeInterest" })
	public String removeInterests(Interest interest, HttpServletRequest req) {
		Integer rowId = Integer.valueOf(req.getParameter("removeInterest"));
		interest.getInterests().remove(rowId.intValue());		
		return "/form/interest";
	}


}

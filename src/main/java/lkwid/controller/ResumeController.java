package lkwid.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lkwid.model.Education;
import lkwid.model.FormSession;
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
	public Personal getPersonal(HttpSession session) {
		return formSession.toPersonal();
	}

	@ModelAttribute
	public Skill getSkill(HttpSession session) {
		return formSession.toSkills();
	}

	@ModelAttribute
	public Education getEducation(HttpSession session) {
		return formSession.toEducation();

	}

	@RequestMapping("/personal")
	public String formPersonal() {		
		return "/form/personal";
	}

	@PostMapping(value = "/personal", params = { "save" })
	public String addPersonal(ModelMap modelMap, Personal personal, BindingResult bindingResult) {
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
	public String addSkills(ModelMap modelMap, Skill skill, BindingResult bindingResult) {
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
	public String addEducation(ModelMap modelMap, Education education, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "/new";
		formSession.saveEducation(education);
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
	
	@RequestMapping(value = "/education", params = { "addCourse"})
	public String addCourseFull(Education education) {
		education.getCourseDates().add(null);
		education.getCourseDescriptions().add(null);
		return "/form/education";
	}

//	@RequestMapping(value = "/education", params = { "addCourseDate" })
//	public String addCourse(Education education) {
//		education.getCourseDates().add(null);
//		return "/form/education";
//	}

	@RequestMapping(value = "/education", params = { "removeCourseDate" })
	public String removeCourse(Education education, HttpServletRequest req) {
		Integer rowId = Integer.valueOf(req.getParameter("removeCourseDate"));
		education.getCourseDates().remove(rowId.intValue());
		return "/form/education";
	}

//	@RequestMapping(value = "/education", params = { "addCourseDescription" })
//	public String addCourseDescription(Education education) {
//		education.getCourseDescriptions().add(null);
//		return "/form/education";
//	}

	@RequestMapping(value = "/education", params = { "removeCourseDescription" })
	public String removeCourseDescription(Education education, HttpServletRequest req) {
		Integer rowId = Integer.valueOf(req.getParameter("removeCourseDescription"));
		education.getCourseDescriptions().remove(rowId.intValue());
		return "/form/education";
	}

}

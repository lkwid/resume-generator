package lkwid.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author lkwid
 *
 */

public class Skill {
	@NotEmpty
	private List<String> skills = new ArrayList<>();
	
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

}

package lkwid.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class Competence {
	@NotEmpty
	private List<String> languages = new ArrayList<>();
	@NotEmpty
	private List<String> proficiency = new ArrayList<>();
	@NotEmpty
	private List<String> drivingLicenceCategory = new ArrayList<>();
	@NotEmpty
	private List<String> perks = new ArrayList<>();
	
	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}
	
	public List<String> getProficiency() {
		return proficiency;
	}

	public void setProficiency(List<String> proficiency) {
		this.proficiency = proficiency;
	}

	public List<String> getDrivingLicenceCategory() {
		return drivingLicenceCategory;
	}

	public void setDrivingLicenceCategory(List<String> drivingLicenceCategory) {
		this.drivingLicenceCategory = drivingLicenceCategory;
	}

	public List<String> getPerks() {
		return perks;
	}

	public void setPerks(List<String> talents) {
		this.perks = talents;
	}

	
}

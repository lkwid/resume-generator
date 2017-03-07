package lkwid.model;

import java.util.ArrayList;
import java.util.List;

public class Competence {
	private List<String> languages = new ArrayList<>();
	private List<String> proficiency = new ArrayList<>();	
	private List<String> drivingLicenceCategory = new ArrayList<>();
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

package lkwid.model;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Experience {
	@NotEmpty
	@DateTimeFormat
	private List<YearMonth> startExperience= new ArrayList<>();
	@NotEmpty
	@DateTimeFormat
	private List<YearMonth> stopExperience= new ArrayList<>();
	@NotEmpty
	private List<String> jobDescriptions = new ArrayList<>();
	
	public List<YearMonth> getStartExperience() {
		return startExperience;
	}
	public void setStartExperience(List<YearMonth> experienceStart) {
		this.startExperience = experienceStart;
	}
	public List<YearMonth> getStopExperience() {
		return stopExperience;
	}
	public void setStopExperience(List<YearMonth> experienceFinish) {
		this.stopExperience = experienceFinish;
	}
	public List<String> getJobDescriptions() {
		return jobDescriptions;
	}
	public void setJobDescriptions(List<String> jobDescription) {
		this.jobDescriptions = jobDescription;
	}
	
}

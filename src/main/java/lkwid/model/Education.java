package lkwid.model;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author lkwid
 *
 */

public class Education {	
	@NotEmpty
	@DateTimeFormat
	private List<YearMonth> courseDates = new ArrayList<>();
	@NotEmpty
	private List<String> courseDescriptions = new ArrayList<>();
		
	public List<YearMonth> getCourseDates() {
		return courseDates;
	}
	public void setCourseDates(List<YearMonth> courseDate) {
		this.courseDates = courseDate;
	}
	public List<String> getCourseDescriptions() {
		return courseDescriptions;
	}
	public void setCourseDescriptions(List<String> courseDescription) {
		this.courseDescriptions = courseDescription;
	}	
	
}

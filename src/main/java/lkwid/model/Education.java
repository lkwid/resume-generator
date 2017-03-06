package lkwid.model;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lkwid
 *
 */

public class Education {	
	private List<YearMonth> courseDates = new ArrayList<>();
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

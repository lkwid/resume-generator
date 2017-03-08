package lkwid.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author lkwid
 *
 */

public class Interest {
	@NotEmpty
	private List<String> interests = new ArrayList<>();
	
	public List<String> getInterests() {
		return interests;
	}
	public void setInterests(List<String> skills) {
		this.interests = skills;
	}

}

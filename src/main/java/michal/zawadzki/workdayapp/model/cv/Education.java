/*
 created on 31.12.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.cv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "education")
@PrimaryKeyJoinColumn(name = "experienceId")
public class Education extends Experience {

	@Column(name = "school_name", nullable = false)
	private String schoolName;

	private String title;

	public Education() {
	}

	public Education(CV cv, Integer startYear, Integer endYear, String shortDescription, String schoolName, String title) {
		super(cv, startYear, endYear, shortDescription);
		this.schoolName = schoolName;
		this.title = title;
	}

	@Override
	public String toString() {
		return "Education{" + "schoolName='" + schoolName + '\'' + ", title='" + title + '\'' + "} " + super.toString();
	}

}

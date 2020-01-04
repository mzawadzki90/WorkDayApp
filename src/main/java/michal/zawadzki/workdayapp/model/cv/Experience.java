/*
 created on 31.12.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.cv;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cv_id", nullable = false)
	private CV cv;

	@Column(name = "start_year", nullable = false)
	private Integer startYear;

	@Column(name = "end_year")
	private Integer endYear;

	@Column(name = "short_description")
	private String shortDescription;

	public Experience() {
	}

	public Experience(CV cv, Integer startYear, Integer endYear, String shortDescription) {
		this.cv = cv;
		this.startYear = startYear;
		this.endYear = endYear;
		this.shortDescription = shortDescription;
	}

	public int getId() {
		return id;
	}

	public CV getCv() {
		return cv;
	}

	public Integer getStartYear() {
		return startYear;
	}

	public Integer getEndYear() {
		return endYear;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	@Override
	public String toString() {
		return "Experience{" + "id=" + id + ", cv=" + cv + ", startYear=" + startYear + ", endYear=" + endYear + ", shortDescription='"
				+ shortDescription + '\'' + '}';
	}

}

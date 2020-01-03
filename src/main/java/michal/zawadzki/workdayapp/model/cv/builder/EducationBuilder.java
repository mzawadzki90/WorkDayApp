/*
 created on 03.01.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.cv.builder;

import michal.zawadzki.workdayapp.model.cv.CV;
import michal.zawadzki.workdayapp.model.cv.Education;

public class EducationBuilder {

	private CV cv;
	private Integer startYear;
	private Integer endYear;
	private String shortDescription;
	private String schoolName;
	private String title;

	public EducationBuilder withCv(CV cv) {
		this.cv = cv;
		return this;
	}

	public EducationBuilder withStartYear(Integer startYear) {
		this.startYear = startYear;
		return this;
	}

	public EducationBuilder withEndYear(Integer endYear) {
		this.endYear = endYear;
		return this;
	}

	public EducationBuilder withShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
		return this;
	}

	public EducationBuilder withSchoolName(String schoolName) {
		this.schoolName = schoolName;
		return this;
	}

	public EducationBuilder withTitle(String title) {
		this.title = title;
		return this;
	}

	public Education build() {
		return new Education(cv, startYear, endYear, shortDescription, schoolName, title);
	}

}
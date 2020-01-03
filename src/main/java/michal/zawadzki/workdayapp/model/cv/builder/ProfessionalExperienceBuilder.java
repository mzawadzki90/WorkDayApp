/*
 created on 03.01.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.cv.builder;

import michal.zawadzki.workdayapp.model.cv.CV;
import michal.zawadzki.workdayapp.model.cv.ProfessionalExperience;

public class ProfessionalExperienceBuilder {

	private CV cv;
	private Integer startYear;
	private Integer endYear;
	private String shortDescription;
	private String companyName;
	private String positionName;

	public ProfessionalExperienceBuilder withCv(CV cv) {
		this.cv = cv;
		return this;
	}

	public ProfessionalExperienceBuilder withStartYear(Integer startYear) {
		this.startYear = startYear;
		return this;
	}

	public ProfessionalExperienceBuilder withEndYear(Integer endYear) {
		this.endYear = endYear;
		return this;
	}

	public ProfessionalExperienceBuilder withShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
		return this;
	}

	public ProfessionalExperienceBuilder withCompanyName(String companyName) {
		this.companyName = companyName;
		return this;
	}

	public ProfessionalExperienceBuilder withPositionName(String positionName) {
		this.positionName = positionName;
		return this;
	}

	public ProfessionalExperience build() {
		return new ProfessionalExperience(cv, startYear, endYear, shortDescription, companyName, positionName);
	}

}
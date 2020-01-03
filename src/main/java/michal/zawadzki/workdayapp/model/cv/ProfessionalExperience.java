/*
 created on 31.12.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.cv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "professional_experience")
public class ProfessionalExperience extends Experience {

	@Column(name = "company_name", nullable = false)
	private String companyName;

	@Column(name = "position_name", nullable = false)
	private String positionName;

	public ProfessionalExperience() {
	}

	public ProfessionalExperience(CV cv, Integer startYear, Integer endYear, String shortDescription, String companyName,
			String positionName) {
		super(cv, startYear, endYear, shortDescription);
		this.companyName = companyName;
		this.positionName = positionName;
	}

	@Override
	public String toString() {
		return "ProfessionalExperience{" + "companyName='" + companyName + '\'' + ", positionName='" + positionName + '\'' + "} "
				+ super.toString();
	}

}

/*
 created on 31.12.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.cv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "professional_experience")
@Data
@EqualsAndHashCode(callSuper = true)
public class ProfessionalExperience extends Experience {

	@Column(name = "company_name", nullable = false)
	private String companyName;

	@Column(name = "position_name", nullable = false)
	private String positionName;

}

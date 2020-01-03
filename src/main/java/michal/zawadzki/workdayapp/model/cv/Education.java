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
@Table(name = "education")
@Data
@EqualsAndHashCode(callSuper = true)
public class Education extends Experience {

	@Column(name = "school_name", nullable = false)
	private String schoolName;

	private String title;

}

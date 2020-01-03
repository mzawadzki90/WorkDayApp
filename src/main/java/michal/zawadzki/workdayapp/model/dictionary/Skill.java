/*
 created on 31.12.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.dictionary;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import michal.zawadzki.workdayapp.model.cv.CV;

@Entity
@Table(name = "skill")
@EqualsAndHashCode(callSuper = true)
public class Skill extends Dictionary {

	@ManyToMany(mappedBy = "skills")
	private Set<CV> employees;

}

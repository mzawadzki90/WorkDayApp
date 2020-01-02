/*
 created on 01.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.worktime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import michal.zawadzki.workdayapp.model.dictionary.SpecialActivity;

@Entity
@Table("special_task")
@Data
@EqualsAndHashCode(callSuper = true)
public class SpecialTask extends Task {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "special_activity_id", nullable = false)
	private SpecialActivity specialActivity;

}

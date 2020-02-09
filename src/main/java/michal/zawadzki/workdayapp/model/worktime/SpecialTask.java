/*
 created on 01.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.worktime;

import michal.zawadzki.workdayapp.model.dictionary.SpecialActivity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "special_task")
public class SpecialTask extends Task {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "special_activity_id", nullable = false)
	private SpecialActivity specialActivity;

	public SpecialTask() {
	}

	public SpecialTask(WorkDay workDay, Long timeMills, SpecialActivity specialActivity) {
		super(workDay, timeMills);
		this.specialActivity = specialActivity;
	}

}

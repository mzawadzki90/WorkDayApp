/*
 created on 01.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.worktime;

import michal.zawadzki.workdayapp.model.dictionary.Project;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "work_task")
public class WorkTask extends Task {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id", nullable = false)
	private Project project;

	public WorkTask() {
	}

	public WorkTask(WorkDay workDay, Long timeMills, Project project) {
		super(workDay, timeMills);
		this.project = project;
	}

}

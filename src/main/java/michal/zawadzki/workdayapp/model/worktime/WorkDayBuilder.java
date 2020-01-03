/*
 created on 03.01.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.worktime;

import java.util.Date;
import java.util.Set;

public class WorkDayBuilder {

	private WorktimeReport worktimeReport;
	private Date date;
	private Date startTime;
	private Date endTime;
	private Set<WorkTask> tasks;

	public WorkDayBuilder withWorktimeReport(WorktimeReport worktimeReport) {
		this.worktimeReport = worktimeReport;
		return this;
	}

	public WorkDayBuilder withDate(Date date) {
		this.date = date;
		return this;
	}

	public WorkDayBuilder withStartTime(Date startTime) {
		this.startTime = startTime;
		return this;
	}

	public WorkDayBuilder withEndTime(Date endTime) {
		this.endTime = endTime;
		return this;
	}

	public WorkDayBuilder withTasks(Set<WorkTask> tasks) {
		this.tasks = tasks;
		return this;
	}

	public WorkDay build() {
		return new WorkDay(worktimeReport, date, startTime, endTime, tasks);
	}

}
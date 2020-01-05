/*
 created on 04.01.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model;

import java.util.Date;
import michal.zawadzki.workdayapp.model.dictionary.Department;
import michal.zawadzki.workdayapp.model.dictionary.Position;
import michal.zawadzki.workdayapp.model.dictionary.Team;

public class OccupationBuilder {

	private Worker worker;
	private Department department;
	private Team team;
	private Position position;
	private Date since;
	private Date till;

	public OccupationBuilder withWorker(Worker worker) {
		this.worker = worker;
		return this;
	}

	public OccupationBuilder withDepartment(Department department) {
		this.department = department;
		return this;
	}

	public OccupationBuilder withTeam(Team team) {
		this.team = team;
		return this;
	}

	public OccupationBuilder withPosition(Position position) {
		this.position = position;
		return this;
	}

	public OccupationBuilder withSince(Date since) {
		this.since = since;
		return this;
	}

	public OccupationBuilder withTill(Date till) {
		this.till = till;
		return this;
	}

	public Occupation build() {
		return new Occupation(worker, department, team, position, since, till);
	}

}
/*
 created on 03.01.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model;

import java.util.List;
import michal.zawadzki.workdayapp.model.cv.CV;
import michal.zawadzki.workdayapp.model.equipment.Rent;
import michal.zawadzki.workdayapp.model.leave.LeaveRequest;
import michal.zawadzki.workdayapp.model.worktime.WorktimeReport;

public class WorkerBuilder {

	private Role role;
	private String email;
	private String firstName;
	private String lastName;
	private Worker supervisor;
	private CV cv;
	private List<Occupation> occupations;
	private List<LeaveRequest> leaveRequests;
	private List<WorktimeReport> worktimeReports;
	private List<Rent> rents;
	private String room;
	private String stationaryNumber;
	private String mobileNumber;

	public WorkerBuilder withRole(Role role) {
		this.role = role;
		return this;
	}

	public WorkerBuilder withEmail(String email) {
		this.email = email;
		return this;
	}

	public WorkerBuilder withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public WorkerBuilder withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public WorkerBuilder withSupervisor(Worker supervisor) {
		this.supervisor = supervisor;
		return this;
	}

	public WorkerBuilder withCv(CV cv) {
		this.cv = cv;
		return this;
	}

	public WorkerBuilder withOccupations(List<Occupation> occupations) {
		this.occupations = occupations;
		return this;
	}

	public WorkerBuilder withLeaveRequests(List<LeaveRequest> leaveRequests) {
		this.leaveRequests = leaveRequests;
		return this;
	}

	public WorkerBuilder withWorktimeReports(List<WorktimeReport> worktimeReports) {
		this.worktimeReports = worktimeReports;
		return this;
	}

	public WorkerBuilder withRents(List<Rent> rents) {
		this.rents = rents;
		return this;
	}

	public WorkerBuilder withRoom(String room) {
		this.room = room;
		return this;
	}

	public WorkerBuilder withStationaryNumber(String stationaryNumber) {
		this.stationaryNumber = stationaryNumber;
		return this;
	}

	public WorkerBuilder withMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
		return this;
	}

	public Worker build() {
		return new Worker(role, email, firstName, lastName, supervisor, cv, occupations, leaveRequests, worktimeReports, rents, room,
				stationaryNumber, mobileNumber);
	}

}
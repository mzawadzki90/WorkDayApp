/*
 created on 31.12.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model;

import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import michal.zawadzki.workdayapp.model.cv.CV;
import michal.zawadzki.workdayapp.model.equipment.Rent;
import michal.zawadzki.workdayapp.model.leave.LeaveRequest;
import michal.zawadzki.workdayapp.model.worktime.WorktimeReport;

@Entity
@Table(name = "worker")
public class Worker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Access(AccessType.PROPERTY)
	private int id;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supervisor_id")
	private Worker supervisor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cv_id")
	private CV cv;

	@OneToMany(mappedBy = "worker")
	@OrderBy("since DESC")
	private List<Occupation> occupations;

	@OneToMany(mappedBy = "id.worker")
	@OrderBy("createdAt DESC")
	private List<LeaveRequest> leaveRequests;

	@OneToMany(mappedBy = "worker")
	@OrderBy("createdAt DESC")
	private List<WorktimeReport> worktimeReports;

	@OneToMany(mappedBy = "id.worker")
	@OrderBy("since DESC")
	private List<Rent> rents;

	private String room;

	@Column(name = "stationary_number")
	private String stationaryNumber;

	@Column(name = "mobile_number")
	private String mobileNumber;

	public Worker() {
	}

	public Worker(Role role, String email, String firstName, String lastName, Worker supervisor, CV cv, List<Occupation> occupations,
			List<LeaveRequest> leaveRequests, List<WorktimeReport> worktimeReports, List<Rent> rents, String room, String stationaryNumber,
			String mobileNumber) {
		this.role = role;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.supervisor = supervisor;
		this.cv = cv;
		this.occupations = occupations;
		this.leaveRequests = leaveRequests;
		this.worktimeReports = worktimeReports;
		this.rents = rents;
		this.room = room;
		this.stationaryNumber = stationaryNumber;
		this.mobileNumber = mobileNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Worker getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Worker supervisor) {
		this.supervisor = supervisor;
	}

	public CV getCv() {
		return cv;
	}

	public void setCv(CV cv) {
		this.cv = cv;
	}

	public List<Occupation> getOccupations() {
		return occupations;
	}

	public void setOccupations(List<Occupation> occupations) {
		this.occupations = occupations;
	}

	public List<LeaveRequest> getLeaveRequests() {
		return leaveRequests;
	}

	public void setLeaveRequests(List<LeaveRequest> leaveRequests) {
		this.leaveRequests = leaveRequests;
	}

	public List<WorktimeReport> getWorktimeReports() {
		return worktimeReports;
	}

	public void setWorktimeReports(List<WorktimeReport> worktimeReports) {
		this.worktimeReports = worktimeReports;
	}

	public List<Rent> getRents() {
		return rents;
	}

	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getStationaryNumber() {
		return stationaryNumber;
	}

	public void setStationaryNumber(String stationaryNumber) {
		this.stationaryNumber = stationaryNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "Worker{" + "id=" + id + ", role=" + role + ", email='" + email + '\'' + ", firstName='" + firstName + '\'' + ", lastName='"
				+ lastName + '\'' + ", supervisor=" + supervisor + ", cv=" + cv + ", occupations=" + occupations + ", leaveRequests="
				+ leaveRequests + ", worktimeReports=" + worktimeReports + ", rents=" + rents + ", room='" + room + '\''
				+ ", stationaryNumber='" + stationaryNumber + '\'' + ", mobileNumber='" + mobileNumber + '\'' + '}';
	}

}

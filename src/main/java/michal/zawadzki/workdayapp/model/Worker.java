/*
 created on 31.12.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model;

import java.util.List;
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
import lombok.Data;
import michal.zawadzki.workdayapp.model.cv.CV;
import michal.zawadzki.workdayapp.model.equipment.Rent;
import michal.zawadzki.workdayapp.model.leave.LeaveRequest;
import michal.zawadzki.workdayapp.model.worktime.WorktimeReport;

@Entity
@Table(name = "worker")
@Data
public class Worker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

}

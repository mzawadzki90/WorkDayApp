/*
 created on 01.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.worktime;

import java.util.Date;
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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import michal.zawadzki.workdayapp.model.Worker;

@Entity
@Table(name = "worktime_report")
@Data
public class WorktimeReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "worker_id", nullable = false)
	private Worker worker;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private WorktimeReportStatus status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_at", nullable = false)
	private Date modifiedAt;

	@OneToMany(mappedBy = "worktimeReport")
	@OrderBy("date")
	private List<WorkDay> workDays;

	@PrePersist
	private void onPersist() {
		Date now = new Date();
		createdAt = now;
		modifiedAt = now;
	}

	@PreUpdate
	private void onUpdate() {
		modifiedAt = new Date();
	}

}

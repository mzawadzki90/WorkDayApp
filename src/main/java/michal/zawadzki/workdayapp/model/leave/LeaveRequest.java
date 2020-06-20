/*
 created on 31.12.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.leave;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import michal.zawadzki.workdayapp.model.Worker;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;

@Entity
@Table(name = "leave_request")
@Getter
@Setter
@NoArgsConstructor
public class LeaveRequest {

	@EmbeddedId
	@AccessType(Type.PROPERTY)
	private LeaveRequestId id;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private LeaveRequestStatus status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt;

	@Column(name = "rejection_reason")
	private String rejectionReason;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_at", nullable = false)
	private Date modifiedAt;

	public LeaveRequest(Worker worker, Leave leave, LeaveRequestStatus status) {
		this.id = new LeaveRequestId(worker, leave);
		this.status = status;
	}

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

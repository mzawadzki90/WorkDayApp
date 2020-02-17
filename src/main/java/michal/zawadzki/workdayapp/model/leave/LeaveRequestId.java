/*
 created on 02.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.leave;

import michal.zawadzki.workdayapp.model.Worker;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LeaveRequestId implements Serializable {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "worker_id", nullable = false)
	private Worker worker;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "leave_id", nullable = false)
	private Leave leave;

	public LeaveRequestId() {
	}

	public LeaveRequestId(int workerId, int leaveId) {
		this.worker = new Worker(workerId);
		this.leave  = new Leave(leaveId);
	}

	public LeaveRequestId(Worker worker, Leave leave) {
		this.worker = worker;
		this.leave  = leave;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public Leave getLeave() {
		return leave;
	}

	public void setLeave(Leave leave) {
		this.leave = leave;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		final LeaveRequestId that = (LeaveRequestId) o;
		return Objects.equals(getWorker(), that.getWorker()) && Objects.equals(getLeave(), that.getLeave());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getWorker(), getLeave());
	}

}

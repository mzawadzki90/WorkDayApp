/*
 created on 02.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.leave;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import michal.zawadzki.workdayapp.model.Worker;

@Embeddable
public class LeaveRequestId implements Serializable {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "worker_id", nullable = false)
	private Worker worker;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "leave_id", nullable = false)
	private Leave leave;

}

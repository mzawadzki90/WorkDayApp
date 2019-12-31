/*
 created on 02.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.equipment;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import michal.zawadzki.workdayapp.model.Worker;

@Embeddable
@Data
public class RentId implements Serializable {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "worker_id", nullable = false)
	private Worker worker;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "equipment_id", nullable = false)
	private Equipment equipment;

}

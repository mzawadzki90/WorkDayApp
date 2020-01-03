/*
 created on 02.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.equipment;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import michal.zawadzki.workdayapp.model.Worker;

@Embeddable
public class RentId implements Serializable {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "worker_id", nullable = false)
	private Worker worker;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "equipment_id", nullable = false)
	private Equipment equipment;

	public RentId() {
	}

	public RentId(Worker worker, Equipment equipment) {
		this.worker = worker;
		this.equipment = equipment;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		final RentId rentId = (RentId) o;
		return Objects.equals(getWorker(), rentId.getWorker()) && Objects.equals(getEquipment(), rentId.getEquipment());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getWorker(), getEquipment());
	}

	@Override
	public String toString() {
		return "RentId{" + "worker=" + worker + ", equipment=" + equipment + '}';
	}

}

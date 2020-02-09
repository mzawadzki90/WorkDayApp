/*
 created on 01.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.equipment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "equipment")
public class Equipment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private EquipmentCategory category;

	@Column(nullable = false)
	private String model;

	private String producer;

	@Column(name = "production_year")
	private Integer productionYear;

	@OneToMany(mappedBy = "id.equipment")
	@OrderBy("since DESC")
	private List<Rent> rents;

	public Equipment() {
	}

	public Equipment(EquipmentCategory category, String model, String producer, Integer productionYear, List<Rent> rents) {
		this.category = category;
		this.model = model;
		this.producer = producer;
		this.productionYear = productionYear;
		this.rents = rents;
	}

}

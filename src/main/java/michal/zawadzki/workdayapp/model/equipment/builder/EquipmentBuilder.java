/*
 created on 03.01.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.equipment.builder;

import java.util.List;
import michal.zawadzki.workdayapp.model.equipment.Equipment;
import michal.zawadzki.workdayapp.model.equipment.EquipmentCategory;
import michal.zawadzki.workdayapp.model.equipment.Rent;

public class EquipmentBuilder {

	private EquipmentCategory category;
	private String model;
	private String producer;
	private Integer productionYear;
	private List<Rent> rents;

	public EquipmentBuilder withCategory(EquipmentCategory category) {
		this.category = category;
		return this;
	}

	public EquipmentBuilder withModel(String model) {
		this.model = model;
		return this;
	}

	public EquipmentBuilder withProducer(String producer) {
		this.producer = producer;
		return this;
	}

	public EquipmentBuilder withProductionYear(Integer productionYear) {
		this.productionYear = productionYear;
		return this;
	}

	public EquipmentBuilder withRents(List<Rent> rents) {
		this.rents = rents;
		return this;
	}

	public Equipment build() {
		return new Equipment(category, model, producer, productionYear, rents);
	}

}
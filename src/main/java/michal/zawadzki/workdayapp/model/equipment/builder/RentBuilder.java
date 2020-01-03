/*
 created on 03.01.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.equipment.builder;

import java.util.Date;
import michal.zawadzki.workdayapp.model.equipment.Rent;
import michal.zawadzki.workdayapp.model.equipment.RentId;

public class RentBuilder {

	private RentId id;
	private Date since;
	private Date till;
	private String comments;

	public RentBuilder withId(RentId id) {
		this.id = id;
		return this;
	}

	public RentBuilder withSince(Date since) {
		this.since = since;
		return this;
	}

	public RentBuilder withTill(Date till) {
		this.till = till;
		return this;
	}

	public RentBuilder withComments(String comments) {
		this.comments = comments;
		return this;
	}

	public Rent build() {
		return new Rent(id, since, till, comments);
	}

}
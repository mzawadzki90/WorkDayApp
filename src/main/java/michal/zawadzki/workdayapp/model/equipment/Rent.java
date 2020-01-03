/*
 created on 01.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.equipment;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "rent")
public class Rent {

	@EmbeddedId
	private RentId id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date since;

	@Temporal(TemporalType.TIMESTAMP)
	private Date till;

	private String comments;

	public Rent() {
	}

	public Rent(RentId id, Date since, Date till, String comments) {
		this.id = id;
		this.since = since;
		this.till = till;
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Rent{" + "id=" + id + ", since=" + since + ", till=" + till + ", comments='" + comments + '\'' + '}';
	}

}

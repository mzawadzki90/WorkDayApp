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
import lombok.Data;

@Entity
@Table(name = "rent")
@Data
public class Rent {

	@EmbeddedId
	private RentId id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date since;

	@Temporal(TemporalType.TIMESTAMP)
	private Date till;

	private String comments;

}

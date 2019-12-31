/*
 created on 31.12.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.leave;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import michal.zawadzki.workdayapp.model.Worker;

@Entity
@Table(name = "leave")
@Data
public class Leave {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private LeaveType type;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date since;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date till;

	private int days; // number of working days

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "replacement_id")
	private Worker replacement;

}

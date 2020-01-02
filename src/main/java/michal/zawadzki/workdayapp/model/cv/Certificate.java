/*
 created on 31.12.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.cv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "certificate")
@Data
@EqualsAndHashCode(callSuper = true)
public class Certificate extends Experience {

	@Column(nullable = false)
	private String name;

	@Column(name = "issued_by", nullable = false)
	private String issuedBy;

}

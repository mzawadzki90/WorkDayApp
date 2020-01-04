/*
 created on 31.12.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.cv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "certificate")
public class Certificate extends Experience {

	@Column(nullable = false)
	private String name;

	@Column(name = "issued_by", nullable = false)
	private String issuedBy;

	public Certificate() {
	}

	public Certificate(CV cv, Integer startYear, Integer endYear, String shortDescription, String name, String issuedBy) {
		super(cv, startYear, endYear, shortDescription);
		this.name = name;
		this.issuedBy = issuedBy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	@Override
	public String toString() {
		return "Certificate{" + "name='" + name + '\'' + ", issuedBy='" + issuedBy + '\'' + "} " + super.toString();
	}

}

/*
 created on 04.01.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.cv.builder;

import michal.zawadzki.workdayapp.model.cv.CV;
import michal.zawadzki.workdayapp.model.cv.Certificate;

public class CertificateBuilder {

	private CV cv;
	private Integer startYear;
	private Integer endYear;
	private String shortDescription;
	private String name;
	private String issuedBy;

	public CertificateBuilder withCv(CV cv) {
		this.cv = cv;
		return this;
	}

	public CertificateBuilder withStartYear(Integer startYear) {
		this.startYear = startYear;
		return this;
	}

	public CertificateBuilder withEndYear(Integer endYear) {
		this.endYear = endYear;
		return this;
	}

	public CertificateBuilder withShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
		return this;
	}

	public CertificateBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public CertificateBuilder withIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
		return this;
	}

	public Certificate build() {
		return new Certificate(cv, startYear, endYear, shortDescription, name, issuedBy);
	}

}
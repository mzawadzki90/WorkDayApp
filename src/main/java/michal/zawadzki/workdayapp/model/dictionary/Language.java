/*
 created on 31.12.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.dictionary;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "language")
public class Language extends Dictionary {

	public Language() {
	}

	public Language(String name) {
		super(name);
	}

}

/*
 created on 31.12.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.dictionary;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "position")
public class Position extends Dictionary {

	public Position() {
	}

	public Position(String name) {
		super(name);
	}

}

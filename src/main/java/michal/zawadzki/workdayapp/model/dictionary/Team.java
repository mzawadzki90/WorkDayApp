/*
 created on 31.12.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.dictionary;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team extends Dictionary {

	public Team() {
	}

	public Team(String name) {
		super(name);
	}

}

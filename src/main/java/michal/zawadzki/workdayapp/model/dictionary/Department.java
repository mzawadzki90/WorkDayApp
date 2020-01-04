/*
 created on 31.12.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.dictionary;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department extends Dictionary {

	public Department() {
	}

	public Department(String name) {
		super(name);
	}

}

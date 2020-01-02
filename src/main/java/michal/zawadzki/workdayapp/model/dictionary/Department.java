/*
 created on 31.12.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.dictionary;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "department")
@EqualsAndHashCode(callSuper = true)
public class Department extends Dictionary {

}

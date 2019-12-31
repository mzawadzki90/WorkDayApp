/*
 created on 01.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.dictionary;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "project")
@EqualsAndHashCode(callSuper = true)
public class Project extends Dictionary {

}

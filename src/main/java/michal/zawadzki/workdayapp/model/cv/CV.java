/*
 created on 31.12.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.cv;

import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import lombok.Data;
import michal.zawadzki.workdayapp.model.Worker;
import michal.zawadzki.workdayapp.model.dictionary.Skill;

@Entity
@Data
@Table(name = "cv")
public class CV {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "worker_id", nullable = false)
	private Worker worker;

	@OneToMany(mappedBy = "cv")
	private Set<Skill> skills;

	@OneToMany(mappedBy = "cv")
	@OrderBy("startYear DESC")
	private List<ProfessionalExperience> experiences;

	@OneToMany(mappedBy = "cv")
	@OrderBy("startYear DESC")
	private List<Education> educations;

	@OneToMany(mappedBy = "cv")
	private Set<LanguageSkill> languageSkills;

	@OneToMany(mappedBy = "cv")
	@OrderBy("startYear DESC")
	private List<Certificate> certificates;

}

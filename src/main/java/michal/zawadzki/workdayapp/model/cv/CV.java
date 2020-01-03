/*
 created on 31.12.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.cv;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import michal.zawadzki.workdayapp.model.Worker;
import michal.zawadzki.workdayapp.model.dictionary.Skill;

@Entity
@Table(name = "cv")
public class CV {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "worker_id", nullable = false)
	private Worker worker;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "cv_to_skill", joinColumns = { @JoinColumn(name = "cv_id") }, inverseJoinColumns = { @JoinColumn(name = "skill_id") })
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

	public CV() {
	}

	public CV(Worker worker, Set<Skill> skills, List<ProfessionalExperience> experiences, List<Education> educations,
			Set<LanguageSkill> languageSkills, List<Certificate> certificates) {
		this.worker = worker;
		this.skills = skills;
		this.experiences = experiences;
		this.educations = educations;
		this.languageSkills = languageSkills;
		this.certificates = certificates;
	}

}

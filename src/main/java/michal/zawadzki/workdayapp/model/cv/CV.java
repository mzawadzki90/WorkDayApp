/*
 created on 31.12.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.cv;

import java.util.List;
import java.util.Set;
import javax.persistence.Access;
import javax.persistence.AccessType;
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
	@Access(AccessType.PROPERTY)
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	public List<ProfessionalExperience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<ProfessionalExperience> experiences) {
		this.experiences = experiences;
	}

	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	public Set<LanguageSkill> getLanguageSkills() {
		return languageSkills;
	}

	public void setLanguageSkills(Set<LanguageSkill> languageSkills) {
		this.languageSkills = languageSkills;
	}

	public List<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}

	@Override
	public String toString() {
		return "CV{" + "id=" + id + ", worker=" + worker + ", skills=" + skills + ", experiences=" + experiences + ", educations="
				+ educations + ", languageSkills=" + languageSkills + ", certificates=" + certificates + '}';
	}

}

/*
 created on 03.01.2019
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.model.cv.builder;

import java.util.List;
import java.util.Set;
import michal.zawadzki.workdayapp.model.Worker;
import michal.zawadzki.workdayapp.model.cv.CV;
import michal.zawadzki.workdayapp.model.cv.Certificate;
import michal.zawadzki.workdayapp.model.cv.Education;
import michal.zawadzki.workdayapp.model.cv.LanguageSkill;
import michal.zawadzki.workdayapp.model.cv.ProfessionalExperience;
import michal.zawadzki.workdayapp.model.dictionary.Skill;

public class CVBuilder {

	private Worker worker;
	private Set<Skill> skills;
	private List<ProfessionalExperience> experiences;
	private List<Education> educations;
	private Set<LanguageSkill> languageSkills;
	private List<Certificate> certificates;

	public CVBuilder withWorker(Worker worker) {
		this.worker = worker;
		return this;
	}

	public CVBuilder withSkills(Set<Skill> skills) {
		this.skills = skills;
		return this;
	}

	public CVBuilder withExperiences(List<ProfessionalExperience> experiences) {
		this.experiences = experiences;
		return this;
	}

	public CVBuilder withEducations(List<Education> educations) {
		this.educations = educations;
		return this;
	}

	public CVBuilder withLanguageSkills(Set<LanguageSkill> languageSkills) {
		this.languageSkills = languageSkills;
		return this;
	}

	public CVBuilder withCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
		return this;
	}

	public CV build() {
		return new CV(worker, skills, experiences, educations, languageSkills, certificates);
	}

}
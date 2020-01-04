package michal.zawadzki.workdayapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import michal.zawadzki.workdayapp.model.Occupation;
import michal.zawadzki.workdayapp.model.OccupationBuilder;
import michal.zawadzki.workdayapp.model.Role;
import michal.zawadzki.workdayapp.model.Worker;
import michal.zawadzki.workdayapp.model.WorkerBuilder;
import michal.zawadzki.workdayapp.model.cv.CV;
import michal.zawadzki.workdayapp.model.cv.Certificate;
import michal.zawadzki.workdayapp.model.cv.Education;
import michal.zawadzki.workdayapp.model.cv.Experience;
import michal.zawadzki.workdayapp.model.cv.LanguageLevel;
import michal.zawadzki.workdayapp.model.cv.LanguageSkill;
import michal.zawadzki.workdayapp.model.cv.ProfessionalExperience;
import michal.zawadzki.workdayapp.model.cv.builder.CVBuilder;
import michal.zawadzki.workdayapp.model.cv.builder.CertificateBuilder;
import michal.zawadzki.workdayapp.model.cv.builder.EducationBuilder;
import michal.zawadzki.workdayapp.model.cv.builder.ProfessionalExperienceBuilder;
import michal.zawadzki.workdayapp.model.dictionary.Department;
import michal.zawadzki.workdayapp.model.dictionary.Language;
import michal.zawadzki.workdayapp.model.dictionary.Position;
import michal.zawadzki.workdayapp.model.dictionary.Skill;
import michal.zawadzki.workdayapp.model.dictionary.Team;
import michal.zawadzki.workdayapp.repository.CVRepository;
import michal.zawadzki.workdayapp.repository.ExperienceRepository;
import michal.zawadzki.workdayapp.repository.WorkerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class Main {

	@Autowired
	private EntityManager em;

	@Autowired
	private WorkerRepository workerRepository;

	@Autowired
	private CVRepository cvRepository;

	@Autowired
	private ExperienceRepository experienceRepository;

	@Test
	void creationAndReadOfAllObjectsShouldSucceed() {
		Worker worker = new WorkerBuilder().withFirstName("Jan")
				.withLastName("Kowalski")
				.withRole(Role.REGULAR_EMPLOYEE)
				.withEmail("jan.kowalski@test.pl")
				.build();

		em.persist(worker);

		Department department = new Department("Test Department");
		em.persist(department);

		Team team = new Team("Test team");
		em.persist(team);

		Position position1 = new Position("Starszy programista");
		em.persist(position1);

		Occupation occupation1 = new OccupationBuilder().withWorker(worker)
				.withDepartment(department)
				.withTeam(team)
				.withPosition(position1)
				.withSince(Date.valueOf(LocalDate.of(2014, 3, 12)))
				.withTill(Date.valueOf(LocalDate.of(2017, 6, 30)))
				.build();
		em.persist(occupation1);

		Position position2 = new Position("Architekt systemów");
		em.persist(position2);

		Occupation occupation2 = new OccupationBuilder().withWorker(worker)
				.withDepartment(department)
				.withTeam(team)
				.withPosition(position2)
				.withSince(Date.valueOf(LocalDate.of(2017, 7, 1)))
				.build();
		em.persist(occupation2);

		Skill skill = new Skill("Programowanie");
		em.persist(skill);

		CV cv = new CVBuilder().withWorker(worker).withSkills(Collections.singleton(skill)).build();
		em.persist(cv);

		Language language = new Language("Angielski");
		em.persist(language);

		LanguageSkill languageSkill = new LanguageSkill(cv, language, LanguageLevel.B2);
		em.persist(languageSkill);

		ProfessionalExperience professionalExperience = new ProfessionalExperienceBuilder().withCv(cv)
				.withCompanyName("Firma testowa")
				.withPositionName("Programista")
				.withStartYear(1999)
				.withEndYear(2009)
				.build();
		em.persist(professionalExperience);

		Education education = new EducationBuilder().withCv(cv)
				.withSchoolName("Politechnika Warszawska")
				.withStartYear(2009)
				.withEndYear(2012)
				.withTitle("Inżynier")
				.build();
		em.persist(education);

		Certificate certificate = new CertificateBuilder().withCv(cv)
				.withIssuedBy("British Council")
				.withName("FCE")
				.withStartYear(2008)
				.build();
		em.persist(certificate);

		em.flush();
		em.clear();

		List<Worker> workers = workerRepository.listWithCvAndOccupations();
		assertEquals(workers.size(), 1);
		Worker persistedWorker = workers.get(0);
		assertEquals(persistedWorker.getFirstName(), "Jan");
		assertEquals(persistedWorker.getLastName(), "Kowalski");
		assertEquals(persistedWorker.getRole(), Role.REGULAR_EMPLOYEE);
		assertEquals(persistedWorker.getEmail(), "jan.kowalski@test.pl");

		List<Occupation> occupations = persistedWorker.getOccupations();
		assertEquals(occupations.size(), 2);
		Occupation persistedOccupation = occupations.get(0);
		assertEquals(persistedOccupation.getDepartment().getName(), "Test Department");
		assertEquals(persistedOccupation.getTeam().getName(), "Test team");
		assertEquals(persistedOccupation.getPosition().getName(), "Architekt systemów");
		assertEquals(persistedOccupation.getSince(), Date.valueOf(LocalDate.of(2017, 7, 1)));

		List<CV> cvs = cvRepository.listWithMetadata();
		assertEquals(cvs.size(), 1);
		CV persistedCv = cvs.get(0);
		assertEquals(persistedCv.getSkills().iterator().next().getName(), "Programowanie");
		LanguageSkill persistedLanguageSkill = persistedCv.getLanguageSkills().iterator().next();
		assertEquals(persistedLanguageSkill.getLanguage().getName(), "Angielski");
		assertEquals(persistedLanguageSkill.getLevel(), LanguageLevel.B2);

		List<Experience> experiences = experienceRepository.listByWorkerId(worker.getId());
		assertEquals(experiences.size(), 3);
		assertEquals(experiences.stream().filter(Certificate.class::isInstance).count(), 1);
		assertEquals(experiences.stream().filter(Education.class::isInstance).count(), 1);
		assertEquals(experiences.stream().filter(ProfessionalExperience.class::isInstance).count(), 1);
	}

}

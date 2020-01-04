/*
 created on 04.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.service;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.springframework.util.CollectionUtils.isEmpty;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.transaction.Transactional;
import michal.zawadzki.workdayapp.model.cv.CV;
import michal.zawadzki.workdayapp.model.cv.Certificate;
import michal.zawadzki.workdayapp.model.cv.Education;
import michal.zawadzki.workdayapp.model.cv.ProfessionalExperience;
import michal.zawadzki.workdayapp.repository.CVRepository;
import michal.zawadzki.workdayapp.repository.CertificateRepository;
import michal.zawadzki.workdayapp.repository.EducationRepository;
import michal.zawadzki.workdayapp.repository.ProfessionalExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CVService {

	@Autowired
	private CVRepository cvRepository;

	@Autowired
	private CertificateRepository certificateRepository;

	@Autowired
	private EducationRepository educationRepository;

	@Autowired
	private ProfessionalExperienceRepository professionalExperienceRepository;

	@Transactional(value = Transactional.TxType.NOT_SUPPORTED)
	public List<CV> listWithMetadata() {
		List<CV> cvs = cvRepository.listWithMetadata();
		fetchCertificates(cvs);
		fetchEducations(cvs);
		fetchProfessionalExperiences(cvs);

		return cvs;
	}

	private void fetchCertificates(List<CV> cvs) {
		if (isEmpty(cvs))
			return;

		Set<Integer> cvIds = cvs.stream().map(CV::getId).collect(toSet());
		Map<Integer, List<Certificate>> certificateMap = certificateRepository.listByCVIds(cvIds)
				.stream()
				.collect(groupingBy(certificate -> certificate.getCv().getId(), toList()));

		cvs.forEach(cv -> {
			cv.setCertificates(certificateMap.getOrDefault(cv.getId(), emptyList()));
		});
	}

	private void fetchEducations(List<CV> cvs) {
		if (isEmpty(cvs))
			return;

		Set<Integer> cvIds = cvs.stream().map(CV::getId).collect(toSet());
		Map<Integer, List<Education>> educationMap = educationRepository.listByCVIds(cvIds)
				.stream()
				.collect(groupingBy(education -> education.getCv().getId(), toList()));

		cvs.forEach(cv -> {
			cv.setEducations(educationMap.getOrDefault(cv.getId(), emptyList()));
		});
	}

	private void fetchProfessionalExperiences(List<CV> cvs) {
		if (isEmpty(cvs))
			return;

		Set<Integer> cvIds = cvs.stream().map(CV::getId).collect(toSet());
		Map<Integer, List<ProfessionalExperience>> experienceMap = professionalExperienceRepository.listByCVIds(cvIds)
				.stream()
				.collect(groupingBy(education -> education.getCv().getId(), toList()));

		cvs.forEach(cv -> {
			cv.setExperiences(experienceMap.getOrDefault(cv.getId(), emptyList()));
		});
	}

}

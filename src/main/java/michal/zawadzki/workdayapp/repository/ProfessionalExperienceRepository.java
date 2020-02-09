/*
 created on 04.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.repository;

import michal.zawadzki.workdayapp.model.cv.ProfessionalExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProfessionalExperienceRepository extends JpaRepository<ProfessionalExperience, Integer> {

	@Query(value = "SELECT pe FROM ProfessionalExperience pe WHERE pe.cv.id IN (:cvIds)")
	List<ProfessionalExperience> listByCVIds(Set<Integer> cvIds);

}

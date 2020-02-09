/*
 created on 04.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.repository;

import michal.zawadzki.workdayapp.model.cv.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer> {

	@Query(value = "SELECT e FROM Education e WHERE e.cv.id IN (:cvIds)")
	List<Education> listByCVIds(Set<Integer> cvIds);

}

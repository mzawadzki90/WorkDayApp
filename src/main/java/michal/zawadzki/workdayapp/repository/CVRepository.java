/*
 created on 04.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.repository;

import michal.zawadzki.workdayapp.model.cv.CV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CVRepository extends JpaRepository<CV, Integer> {

	@Query(value =
			"SELECT DISTINCT cv FROM CV cv LEFT JOIN FETCH cv.worker LEFT JOIN FETCH cv.skills s LEFT JOIN FETCH cv.languageSkills ls"
					+ " LEFT JOIN FETCH ls.language ")
	List<CV> listWithMetadata();

}

/*
 created on 04.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.repository;

import java.util.List;
import michal.zawadzki.workdayapp.model.cv.CV;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVRepository extends CrudRepository<Integer, CV> {

	@Query(value =
			"SELECT cv FROM CV cv LEFT JOIN FETCH cv.worker LEFT JOIN FETCH cv.skills s LEFT JOIN FETCH s.name LEFT JOIN FETCH cv.experiences"
					+ " LEFT JOIN FETCH cv.educations LEFT JOIN FETCH cv.languageSkills ls LEFT JOIN FETCH ls.language LEFT JOIN FETCH cv.certificates")
	List<CV> listWithMetadata();

}

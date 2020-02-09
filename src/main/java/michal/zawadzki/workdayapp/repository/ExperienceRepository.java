/*
 created on 05.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.repository;

import michal.zawadzki.workdayapp.model.cv.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {

	@Query(value = "SELECT e FROM Experience e JOIN e.cv c JOIN c.worker w WHERE w.id = :workerId")
	List<Experience> listByWorkerId(int workerId);

}

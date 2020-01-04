/*
 created on 04.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.repository;

import java.util.List;
import michal.zawadzki.workdayapp.model.Worker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends CrudRepository<Integer, Worker> {

	@Query(value = "SELECT w FROM Worker w LEFT JOIN FETCH w.cv LEFT JOIN FETCH w.occupations o LEFT JOIN FETCH o.department"
			+ " LEFT JOIN FETCH o.position LEFT JOIN FETCH o.team")
	List<Worker> listWithCvAndOccupations();

}

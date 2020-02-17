/*
 created on 04.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.repository;

import michal.zawadzki.workdayapp.model.Worker;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {

	@Query("SELECT DISTINCT w FROM Worker w LEFT JOIN FETCH w.cv LEFT JOIN FETCH w.occupations o LEFT JOIN FETCH o.department"
		   + " LEFT JOIN FETCH o.position LEFT JOIN FETCH o.team")
	List<Worker> listWithCvAndOccupations();

	@Query("SELECT w FROM Worker w WHERE w.id <> :omittedId")
	List<Worker> findAllWithoutId(int omittedId, Sort lastName);

	List<Worker> findAllByIdIn(Set<Integer> workerIds);

}

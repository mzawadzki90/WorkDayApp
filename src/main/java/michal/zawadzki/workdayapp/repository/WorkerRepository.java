/*
 created on 04.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.repository;

import java.util.List;
import java.util.Set;
import michal.zawadzki.workdayapp.model.Worker;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {

    @Query("SELECT DISTINCT w FROM Worker w LEFT JOIN FETCH w.cv LEFT JOIN FETCH w.occupations o LEFT JOIN FETCH o.department"
            + " LEFT JOIN FETCH o.position LEFT JOIN FETCH o.team")
    List<Worker> listWithCvAndOccupations();

    @Query("SELECT w FROM Worker w WHERE w.id <> :omittedId")
    List<Worker> findAllWithoutId(int omittedId, Sort lastName);

    List<Worker> findAllByIdIn(Set<Integer> workerIds);

    @Query("SELECT DISTINCT w FROM Worker w LEFT JOIN FETCH w.supervisor LEFT JOIN FETCH w.occupations o LEFT JOIN FETCH o.position"
            + " LEFT JOIN FETCH o.department  LEFT JOIN FETCH o.team ORDER BY w.lastName ASC, w.firstName ASC")
    List<Worker> listWithSupervisorAndOccupations();

    @Query("SELECT DISTINCT w FROM Worker w LEFT JOIN FETCH w.supervisor LEFT JOIN FETCH w.occupations o LEFT JOIN FETCH o.position"
            + " LEFT JOIN FETCH o.department  LEFT JOIN FETCH o.team WHERE LOWER(w.lastName) LIKE LOWER(:keyword) OR LOWER(w.firstName) LIKE LOWER(:keyword)"
            + " ORDER BY w.lastName ASC, w.firstName ASC")
    List<Worker> listWithSupervisorAndOccupationsByKeyword(String keyword);

}

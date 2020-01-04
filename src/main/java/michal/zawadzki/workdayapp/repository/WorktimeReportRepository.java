/*
 created on 04.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.repository;

import java.util.List;
import michal.zawadzki.workdayapp.model.worktime.WorktimeReport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorktimeReportRepository extends CrudRepository<Integer, WorktimeReport> {

	@Query(value = "SELECT wr FROM WorktimeReport wr LEFT JOIN FETCH wr.worker w LEFT JOIN FETCH wr.workDays wd LEFT JOIN FETCH wd.tasks t"
			+ " LEFT JOIN FETCH t.project LEFT JOIN FETCH wd.specialTasks st LEFT JOIN FETCH st.specialActivity WHERE w.id = :workerId")
	List<WorktimeReport> listByWorkerId(int workerId);

}
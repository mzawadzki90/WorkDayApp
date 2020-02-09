/*
 created on 04.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.repository;

import michal.zawadzki.workdayapp.model.worktime.WorktimeReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorktimeReportRepository extends JpaRepository<WorktimeReport, Integer> {

	@Query(value = "SELECT wr FROM WorktimeReport wr LEFT JOIN FETCH wr.worker w LEFT JOIN FETCH wr.workDays wd LEFT JOIN FETCH wd.tasks t"
			+ " LEFT JOIN FETCH t.project LEFT JOIN FETCH wd.specialTasks st LEFT JOIN FETCH st.specialActivity WHERE w.id = :workerId")
	List<WorktimeReport> listByWorkerId(int workerId);

}

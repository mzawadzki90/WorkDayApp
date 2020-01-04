/*
 created on 04.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.repository;

import java.util.List;
import michal.zawadzki.workdayapp.model.leave.LeaveRequest;
import michal.zawadzki.workdayapp.model.leave.LeaveRequestId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRequestRepository extends CrudRepository<LeaveRequestId, LeaveRequest> {

	@Query(value =
			"SELECT lr FROM LeaveRequest lr LEFT JOIN FETCH lr.id.worker w LEFT JOIN FETCH lr.id.leave l LEFT JOIN FETCH l.replacement r"
					+ " WHERE w.id = :workerId")
	List<LeaveRequest> listByWorkerId(int workerId);

}

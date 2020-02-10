/*
 created on 04.01.2020
 by Michał Zawadzki
*/
package michal.zawadzki.workdayapp.repository;

import michal.zawadzki.workdayapp.model.leave.LeaveRequest;
import michal.zawadzki.workdayapp.model.leave.LeaveRequestId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, LeaveRequestId> {

    @Query("SELECT lr FROM LeaveRequest lr JOIN lr.id.worker w WHERE w.id = :workerId")
    Page<LeaveRequest> listByWorkerId(int workerId, Pageable pageable);

    @Query("SELECT DISTINCT lr FROM LeaveRequest lr LEFT JOIN FETCH lr.id.leave l JOIN lr.id.worker w WHERE lr.status IN ('CREATED', 'ACCEPTED')" +
           " AND l.since > :yearStart AND w.id = :workerId")
    List<LeaveRequest> findAcceptedAndCreatedByWorkerId(int workerId, Date yearStart);
}

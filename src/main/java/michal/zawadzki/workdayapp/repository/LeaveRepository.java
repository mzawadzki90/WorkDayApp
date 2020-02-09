package michal.zawadzki.workdayapp.repository;

import michal.zawadzki.workdayapp.model.leave.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Integer> {

    List<Leave> findAllByIdIn(Set<Integer> ids);

}


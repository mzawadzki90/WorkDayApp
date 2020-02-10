package michal.zawadzki.workdayapp.service;

import michal.zawadzki.workdayapp.model.Worker;
import michal.zawadzki.workdayapp.repository.LeaveRequestRepository;
import michal.zawadzki.workdayapp.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;

@Service
public class WorkerService {

    @Value("${workdayapp.free.days.amount}")
    private int freeDays;

    private final WorkerRepository workerRepository;

    private final LeaveRequestRepository leaveRequestRepository;

    public WorkerService(WorkerRepository workerRepository,
                         LeaveRequestRepository leaveRequestRepository) {
        this.workerRepository       = workerRepository;
        this.leaveRequestRepository = leaveRequestRepository;
    }

    public List<Worker> findAllWithoutIdOrderedByLastName(int omittedId) {
        return workerRepository.findAllWithoutId(omittedId, Sort.by(Sort.Order.asc("lastName")));
    }

    public int getFreeDays(int workerId) {
        final int used = leaveRequestRepository.countAcceptedAndCreatedByWorkerId(workerId, yearStart());
        return freeDays - used;
    }

    private Date yearStart() {
        final int year = Year.now().getValue();
        return Date.valueOf(LocalDate.of(year, 1, 1));
    }

}

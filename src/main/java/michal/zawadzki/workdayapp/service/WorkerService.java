package michal.zawadzki.workdayapp.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;
import michal.zawadzki.workdayapp.api.error.NoEntityException;
import michal.zawadzki.workdayapp.model.Worker;
import michal.zawadzki.workdayapp.model.leave.LeaveRequest;
import michal.zawadzki.workdayapp.model.worktime.WorkerCredentials;
import michal.zawadzki.workdayapp.repository.LeaveRequestRepository;
import michal.zawadzki.workdayapp.repository.WorkerCredentialsRepository;
import michal.zawadzki.workdayapp.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class WorkerService {

    @Value("${workdayapp.free.days.amount}")
    private int freeDays;

    private final WorkerRepository workerRepository;

    private final LeaveRequestRepository leaveRequestRepository;

    private final WorkerCredentialsRepository workerCredentialsRepository;

    public WorkerService(WorkerRepository workerRepository, LeaveRequestRepository leaveRequestRepository,
            WorkerCredentialsRepository workerCredentialsRepository) {
        this.workerRepository = workerRepository;
        this.leaveRequestRepository = leaveRequestRepository;
        this.workerCredentialsRepository = workerCredentialsRepository;
    }

    public Worker login(String login, String password) {
        return workerCredentialsRepository.getByLoginAndPasswordWithWorker(login, password)
                .map(WorkerCredentials::getWorker)
                .orElseThrow(() -> new NoEntityException("Worker with given credentials not exists."));
    }

    public List<Worker> list(String keyword) {
        if (StringUtils.isEmpty(keyword)) {
            return workerRepository.listWithSupervisorAndOccupations();
        }

        return workerRepository.listWithSupervisorAndOccupationsByKeyword(formatKeyword(keyword));
    }

    public List<Worker> findAllWithoutIdOrderedByLastName(int omittedId) {
        return workerRepository.findAllWithoutId(omittedId, Sort.by(Sort.Order.asc("lastName")));
    }

    public int getFreeDays(int workerId) {
        final List<LeaveRequest> used = leaveRequestRepository.findAcceptedAndCreatedByWorkerId(workerId, yearStart());
        final Integer usedSum = used.stream().map(leaveRequest -> leaveRequest.getId().getLeave().getDays()).reduce(0, Integer::sum);
        return freeDays - usedSum;
    }

    private String formatKeyword(String keyword) {
        if (StringUtils.isEmpty(keyword)) {
            return null;
        }

        return String.format("%%%s%%", keyword);
    }

    private Date yearStart() {
        final int year = Year.now().getValue();
        return Date.valueOf(LocalDate.of(year, 1, 1));
    }

}

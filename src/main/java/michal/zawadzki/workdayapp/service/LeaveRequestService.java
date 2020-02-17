package michal.zawadzki.workdayapp.service;

import michal.zawadzki.workdayapp.api.error.NoEntityException;
import michal.zawadzki.workdayapp.model.Worker;
import michal.zawadzki.workdayapp.model.leave.Leave;
import michal.zawadzki.workdayapp.model.leave.LeaveRequest;
import michal.zawadzki.workdayapp.model.leave.LeaveRequestId;
import michal.zawadzki.workdayapp.model.leave.LeaveRequestStatus;
import michal.zawadzki.workdayapp.repository.LeaveRepository;
import michal.zawadzki.workdayapp.repository.LeaveRequestRepository;
import michal.zawadzki.workdayapp.repository.WorkerRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.springframework.util.CollectionUtils.isEmpty;

@Service
@Scope("prototype")
@Transactional
public class LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;
    private final LeaveRepository leaveRepository;
    private final WorkerRepository workerRepository;
    private final EntityManager entityManager;

    public LeaveRequestService(LeaveRequestRepository leaveRequestRepository,
                               LeaveRepository leaveRepository,
                               WorkerRepository workerRepository,
                               EntityManager entityManager) {
        this.leaveRequestRepository = leaveRequestRepository;
        this.leaveRepository        = leaveRepository;
        this.workerRepository       = workerRepository;
        this.entityManager          = entityManager;
    }

    public Page<LeaveRequest> list(Pageable pageable) {
        final Page<LeaveRequest> page = leaveRequestRepository.findAll(pageable);
        final List<LeaveRequest> leaveRequests = page.getContent();
        fetchLeave(leaveRequests);
        return page;
    }

    public Page<LeaveRequest> listByWorkerId(int workerId, Pageable pageable) {
        final Page<LeaveRequest> page = leaveRequestRepository.listByWorkerId(workerId, pageable);
        final List<LeaveRequest> leaveRequests = page.getContent();
        fetchLeave(leaveRequests);
        return page;
    }

    public void create(int workerId, Leave leave) {
        final Worker worker = workerRepository.findById(workerId)
                                              .orElseThrow(
                                                      () -> new NoEntityException("Worker with given id not exists."));
        entityManager.persist(leave);

        final LeaveRequest leaveRequest = new LeaveRequest(worker, leave, LeaveRequestStatus.CREATED);
        leaveRequestRepository.save(leaveRequest);
    }

    public void updateStatus(int workerId, int leaveId, LeaveRequestStatus status) {
        final Optional<LeaveRequest> optionalLeaveRequest =
                leaveRequestRepository.findById(new LeaveRequestId(workerId, leaveId));
        optionalLeaveRequest
                .orElseThrow(() -> new NoEntityException("Leave request with given parameters not exists"));

        optionalLeaveRequest.get().setStatus(status);
    }

    private void fetchLeave(List<LeaveRequest> leaveRequests) {
        if (isEmpty(leaveRequests)) {
            return;
        }

        final Set<Integer> leaveIds =
                leaveRequests.stream().map(leaveRequest -> leaveRequest.getId().getLeave().getId()).collect(
                        Collectors.toSet());
        final Map<Integer, Leave> leaveMap = leaveRepository.findAllByIdIn(
                leaveIds).stream().collect(Collectors.toMap(Leave::getId, Function.identity()));

        leaveRequests.forEach(
                leaveRequest -> leaveRequest.getId().setLeave(leaveMap.get(leaveRequest.getId().getLeave().getId())));
    }

    private void fetchWorkers(List<LeaveRequest> leaveRequests) {
        if (isEmpty(leaveRequests)) {
            return;
        }

        final Set<Integer> workerIds =
                leaveRequests.stream().map(leaveRequest -> leaveRequest.getId().getWorker().getId()).collect(
                        Collectors.toSet());
        final Map<Integer, Worker> workerMap = workerRepository.findAllByIdIn(workerIds).stream().collect(
                Collectors.toMap(Worker::getId, Function.identity()));

        leaveRequests.forEach(
                leaveRequest -> leaveRequest.getId()
                                            .setWorker(workerMap.get(leaveRequest.getId().getWorker().getId())));
    }

}
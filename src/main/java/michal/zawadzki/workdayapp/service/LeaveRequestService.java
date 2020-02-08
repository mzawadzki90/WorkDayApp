package michal.zawadzki.workdayapp.service;

import michal.zawadzki.workdayapp.api.LeaveRequestDto;
import michal.zawadzki.workdayapp.api.error.NoEntityException;
import michal.zawadzki.workdayapp.api.mapper.LeaveRequestMapper;
import michal.zawadzki.workdayapp.model.Worker;
import michal.zawadzki.workdayapp.model.leave.Leave;
import michal.zawadzki.workdayapp.model.leave.LeaveRequest;
import michal.zawadzki.workdayapp.model.leave.LeaveRequestStatus;
import michal.zawadzki.workdayapp.repository.LeaveRequestRepository;
import michal.zawadzki.workdayapp.repository.WorkerRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@Scope("prototype")
@Transactional
public class LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;

    private final WorkerRepository workerRepository;

    private final LeaveRequestMapper leaveRequestMapper;

    private final EntityManager entityManager;

    public LeaveRequestService(LeaveRequestRepository leaveRequestRepository,
                               WorkerRepository workerRepository,
                               LeaveRequestMapper leaveRequestMapper, EntityManager entityManager) {
        this.leaveRequestRepository = leaveRequestRepository;
        this.workerRepository       = workerRepository;
        this.leaveRequestMapper     = leaveRequestMapper;
        this.entityManager          = entityManager;
    }


    public Page<LeaveRequest> listByWorkerId(int workerId, Pageable pageable) {
        return leaveRequestRepository.listByWorkerId(workerId, pageable);
    }

    public void create(int workerId, LeaveRequestDto leaveRequestDto) {
        final Worker worker = workerRepository.findById(workerId)
                                              .orElseThrow(
                                                      () -> new NoEntityException("Worker with given id not exists."));
        final Leave leave = leaveRequestMapper.fromDto(leaveRequestDto);
        entityManager.persist(leave);

        final LeaveRequest leaveRequest = new LeaveRequest(worker, leave, LeaveRequestStatus.CREATED);
        leaveRequestRepository.save(leaveRequest);
    }

}
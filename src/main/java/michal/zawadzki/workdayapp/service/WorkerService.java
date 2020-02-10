package michal.zawadzki.workdayapp.service;

import michal.zawadzki.workdayapp.model.Worker;
import michal.zawadzki.workdayapp.repository.WorkerRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public List<Worker> findAllWithoutIdOrderedByLastName(int omittedId) {
        return workerRepository.findAllWithoutId(omittedId, Sort.by(Sort.Order.asc("lastName")));
    }
}

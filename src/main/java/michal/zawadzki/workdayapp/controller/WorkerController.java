package michal.zawadzki.workdayapp.controller;

import michal.zawadzki.workdayapp.api.DictionariesDto;
import michal.zawadzki.workdayapp.api.DictionaryDto;
import michal.zawadzki.workdayapp.api.MetaDto;
import michal.zawadzki.workdayapp.api.worker.login.CredentialDto;
import michal.zawadzki.workdayapp.api.worker.login.WorkerLoginDto;
import michal.zawadzki.workdayapp.api.worker.login.WorkerLoginDtoMapper;
import michal.zawadzki.workdayapp.model.Worker;
import michal.zawadzki.workdayapp.service.WorkerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/workers")
public class WorkerController {

    private final WorkerService workerService;

    private final WorkerLoginDtoMapper workerLoginDtoMapper;

    public WorkerController(WorkerService workerService,
                            WorkerLoginDtoMapper workerLoginDtoMapper) {
        this.workerService        = workerService;
        this.workerLoginDtoMapper = workerLoginDtoMapper;
    }

    @PostMapping
    @RequestMapping("login")
    public WorkerLoginDto login(@RequestBody @Valid CredentialDto credentialDto) {
        final Worker worker = workerService.login(credentialDto.getLogin(), credentialDto.getPassword());
        return workerLoginDtoMapper.fromWorker(worker);
    }

    @GetMapping
    @RequestMapping("dictionaries/without/{omittedId}")
    public DictionariesDto dictionaryList(@PathVariable int omittedId) {
        List<Worker> workers = workerService.findAllWithoutIdOrderedByLastName(omittedId);
        final List<DictionaryDto> dictionaries = workers.stream().map(toDictionaryDto()).collect(Collectors.toList());
        final int size = dictionaries.size();
        return new DictionariesDto(new MetaDto(0, size, size), dictionaries);
    }

    private Function<Worker, DictionaryDto> toDictionaryDto() {
        return worker -> new DictionaryDto(worker.getId(), String.format("%s %s %s", worker.getLastName(),
                                                                         worker.getFirstName(), worker.getEmail()));
    }

    @GetMapping
    @RequestMapping("{workerId}/free/days")
    public int getFreeDays(@PathVariable int workerId) {
        return workerService.getFreeDays(workerId);
    }

}

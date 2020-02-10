package michal.zawadzki.workdayapp.controller;

import michal.zawadzki.workdayapp.api.DictionariesDto;
import michal.zawadzki.workdayapp.api.DictionaryDto;
import michal.zawadzki.workdayapp.api.MetaDto;
import michal.zawadzki.workdayapp.model.Worker;
import michal.zawadzki.workdayapp.service.WorkerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/workers")
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
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

}

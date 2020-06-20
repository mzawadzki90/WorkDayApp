package michal.zawadzki.workdayapp.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import michal.zawadzki.workdayapp.api.MetaDto;
import michal.zawadzki.workdayapp.api.leave.LeaveRequestDto;
import michal.zawadzki.workdayapp.api.leave.LeaveRequestMapper;
import michal.zawadzki.workdayapp.api.leave.LeaveRequestStatusDto;
import michal.zawadzki.workdayapp.api.leave.LeaveRequestsDto;
import michal.zawadzki.workdayapp.model.leave.Leave;
import michal.zawadzki.workdayapp.model.leave.LeaveRequest;
import michal.zawadzki.workdayapp.service.LeaveRequestService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/leave/requests")
public class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;
    private final LeaveRequestMapper leaveRequestMapper;

    public LeaveRequestController(LeaveRequestService leaveRequestService,
                                  LeaveRequestMapper leaveRequestMapper) {
        this.leaveRequestService = leaveRequestService;
        this.leaveRequestMapper  = leaveRequestMapper;
    }

    @GetMapping()
    public LeaveRequestsDto list(
            @PageableDefault(size = 50, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        final Page<LeaveRequest> page = leaveRequestService.list(pageable);
        final List<LeaveRequestDto> leaveRequests =
                page.getContent().stream().map(leaveRequestMapper::toDtoWithLeaveAndWorker)
                    .collect(Collectors.toList());
        final MetaDto meta = new MetaDto(page.getNumber(), page.getSize(), page.getTotalPages());

        return new LeaveRequestsDto(meta, leaveRequests);
    }

    @GetMapping("worker/{workerId}")
    public LeaveRequestsDto listByWorkerId(@PathVariable int workerId, @PageableDefault(size = 50, sort = "createdAt",
                                                                                        direction = Sort.Direction.DESC)
            Pageable pageable) {
        final Page<LeaveRequest> page = leaveRequestService.listByWorkerId(workerId, pageable);
        final List<LeaveRequestDto> leaveRequests = page.getContent().stream().map(leaveRequestMapper::toDtoWithLeaveAndWorker)
                    .collect(Collectors.toList());
        final MetaDto meta = new MetaDto(page.getNumber(), page.getSize(), page.getTotalPages());

        return new LeaveRequestsDto(meta, leaveRequests);
    }

    @PostMapping("worker/{workerId}")
    public ResponseEntity<Void> create(@PathVariable int workerId, @RequestBody LeaveRequestDto leaveRequestDto) {
        final Leave leave = leaveRequestMapper.fromDto(leaveRequestDto);
        leaveRequestService.create(workerId, leave);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("worker/{workerId}/leave/{leaveId}")
    public ResponseEntity<Void> updateStatus(@PathVariable int workerId, @PathVariable int leaveId,
                                             @RequestBody @NotNull LeaveRequestStatusDto status
                                            ) {
        leaveRequestService.updateStatus(workerId, leaveId, status.getStatus());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

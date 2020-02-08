package michal.zawadzki.workdayapp.controller;

import michal.zawadzki.workdayapp.api.LeaveRequestDto;
import michal.zawadzki.workdayapp.model.leave.LeaveRequest;
import michal.zawadzki.workdayapp.service.LeaveRequestService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("leave/requests")
public class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;

    public LeaveRequestController(LeaveRequestService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }

    @GetMapping("worker/{workerId}")
    public Page<LeaveRequest> listByWorkerId(@PathVariable int workerId, @RequestParam Pageable pageable) {
        return leaveRequestService.listByWorkerId(workerId, pageable);
    }

    @PostMapping("worker/{workerId}")
    public ResponseEntity<Void> create(@PathVariable int workerId, @RequestBody LeaveRequestDto leaveRequestDto) {
        leaveRequestService.create(workerId, leaveRequestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

package michal.zawadzki.workdayapp.api.leave;

import michal.zawadzki.workdayapp.model.Worker;
import michal.zawadzki.workdayapp.model.leave.Leave;
import michal.zawadzki.workdayapp.model.leave.LeaveRequest;
import org.mapstruct.AfterMapping;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LeaveRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "replacement", ignore = true)
    Leave fromDto(LeaveRequestDto leaveRequestDto);

    @AfterMapping
    default void setReplacement(LeaveRequestDto leaveRequestDto, @MappingTarget Leave leave) {
        final Integer replacementId = leaveRequestDto.getReplacementId();
        if (replacementId == null) {
            return;
        }
        final Worker worker = new Worker();
        worker.setId(replacementId);
        leave.setReplacement(worker);
    }

    default LeaveRequestDto toDtoWithLeaveAndWorker(LeaveRequest leaveRequest) {
        final LeaveRequestDto leaveRequestDto = toDtoWithLeave(leaveRequest);

        final Worker worker = leaveRequest.getId().getWorker();
        leaveRequestDto.setWorkerId(worker.getId());
        leaveRequestDto.setWorkerFirstName(worker.getFirstName());
        leaveRequestDto.setWorkerLastName(worker.getLastName());
        leaveRequestDto.setWorkerEmail(worker.getEmail());

        return leaveRequestDto;
    }

    default LeaveRequestDto toDtoWithLeave(LeaveRequest leaveRequest) {
        final LeaveRequestDto leaveRequestDto = new LeaveRequestDto();
        leaveRequestDto.setStatus(leaveRequest.getStatus());
        leaveRequestDto.setCreatedAt(leaveRequest.getCreatedAt());
        leaveRequestDto.setModifiedAt(leaveRequest.getCreatedAt());

        final Leave leave = leaveRequest.getId().getLeave();
        leaveRequestDto.setLeaveId(leave.getId());
        leaveRequestDto.setType(leave.getType());
        leaveRequestDto.setSince(leave.getSince());
        leaveRequestDto.setTill(leave.getTill());

        return leaveRequestDto;
    }

}

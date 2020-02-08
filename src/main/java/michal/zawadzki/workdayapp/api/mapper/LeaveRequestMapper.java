package michal.zawadzki.workdayapp.api.mapper;

import michal.zawadzki.workdayapp.api.LeaveRequestDto;
import michal.zawadzki.workdayapp.model.Worker;
import michal.zawadzki.workdayapp.model.leave.Leave;
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
        final Worker worker = new Worker();
        worker.setId(leaveRequestDto.getReplacementId());
        leave.setReplacement(worker);
    }

}

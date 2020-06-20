/*
    Created on 20/06/2020 by uex1421
 */
package michal.zawadzki.workdayapp.serializer.worker;

import java.util.List;
import michal.zawadzki.workdayapp.api.DictionaryDto;
import michal.zawadzki.workdayapp.api.worker.OccupationDto;
import michal.zawadzki.workdayapp.api.worker.SimplifiedWorkerDto;
import michal.zawadzki.workdayapp.api.worker.SimplifiedWorkerDtoBuilder;
import michal.zawadzki.workdayapp.api.worker.WorkerDto;
import michal.zawadzki.workdayapp.api.worker.WorkerDtoBuilder;
import michal.zawadzki.workdayapp.model.Occupation;
import michal.zawadzki.workdayapp.model.Worker;
import michal.zawadzki.workdayapp.model.dictionary.Department;
import michal.zawadzki.workdayapp.model.dictionary.Position;
import michal.zawadzki.workdayapp.model.dictionary.Team;
import org.springframework.util.CollectionUtils;

public class WorkerSerializer {

    private WorkerSerializer() {

    }

    public static WorkerDto toWorkerDto(Worker worker) {
        return new WorkerDtoBuilder().withId(worker.getId())
                .withFirstName(worker.getFirstName())
                .withLastName(worker.getLastName())
                .withEmail(worker.getEmail())
                .withMobileNumber(worker.getMobileNumber())
                .withStationaryNumber(worker.getStationaryNumber())
                .withRole(worker.getRole())
                .withRoom(worker.getRoom())
                .withCurrentPosition(getCurrentPosition(worker))
                .withSupervisor(getSupervisor(worker))
                .build();
    }

    private static OccupationDto getCurrentPosition(Worker worker) {
        final List<Occupation> occupations = worker.getOccupations();
        if (CollectionUtils.isEmpty(occupations)) {
            return null;
        }

        return toOccupationDto(occupations.get(0));
    }

    private static OccupationDto toOccupationDto(Occupation occupation) {
        final Position position = occupation.getPosition();
        final Department department = occupation.getDepartment();
        final Team team = occupation.getTeam();

        return OccupationDto.builder()
                .id(occupation.getId())
                .position(new DictionaryDto(position.getId(), position.getName()))
                .department(new DictionaryDto(department.getId(), department.getName()))
                .team(new DictionaryDto(team.getId(), team.getName()))
                .since(occupation.getSince())
                .till(occupation.getTill())
                .build();
    }

    private static SimplifiedWorkerDto getSupervisor(Worker worker) {
        final Worker supervisor = worker.getSupervisor();
        if (supervisor == null) {
            return null;
        }

        return toSimplifiedWorkerDto(supervisor);
    }

    private static SimplifiedWorkerDto toSimplifiedWorkerDto(Worker worker) {
        return new SimplifiedWorkerDtoBuilder().withId(worker.getId())
                .withFirstName(worker.getFirstName())
                .withLastName(worker.getLastName())
                .withEmail(worker.getEmail())
                .withRole(worker.getRole())
                .build();
    }

}

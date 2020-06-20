package michal.zawadzki.workdayapp.api.worker;

import michal.zawadzki.workdayapp.model.Role;

public class WorkerDtoBuilder {

    private int id;
    private Role role;
    private String email;
    private String firstName;
    private String lastName;
    private OccupationDto currentPosition;
    private SimplifiedWorkerDto supervisor;
    private String room;
    private String stationaryNumber;
    private String mobileNumber;

    public WorkerDtoBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public WorkerDtoBuilder withRole(Role role) {
        this.role = role;
        return this;
    }

    public WorkerDtoBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public WorkerDtoBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public WorkerDtoBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public WorkerDtoBuilder withCurrentPosition(OccupationDto currentPosition) {
        this.currentPosition = currentPosition;
        return this;
    }

    public WorkerDtoBuilder withSupervisor(SimplifiedWorkerDto supervisor) {
        this.supervisor = supervisor;
        return this;
    }

    public WorkerDtoBuilder withRoom(String room) {
        this.room = room;
        return this;
    }

    public WorkerDtoBuilder withStationaryNumber(String stationaryNumber) {
        this.stationaryNumber = stationaryNumber;
        return this;
    }

    public WorkerDtoBuilder withMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    public WorkerDto build() {
        return new WorkerDto(id, role, email, firstName, lastName, currentPosition, supervisor, room, stationaryNumber, mobileNumber);
    }

}
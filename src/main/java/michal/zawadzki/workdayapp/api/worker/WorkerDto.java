/*
    Created on 20/06/2020 by uex1421
 */
package michal.zawadzki.workdayapp.api.worker;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import michal.zawadzki.workdayapp.model.Role;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkerDto extends SimplifiedWorkerDto {

    @JsonProperty("current_position")
    private OccupationDto currentPosition;

    private SimplifiedWorkerDto supervisor;

    private String room;

    @JsonProperty("stationary_number")
    private String stationaryNumber;

    @JsonProperty("mobile_number")
    private String mobileNumber;

    public WorkerDto() {
    }

    public WorkerDto(int id, Role role, String email, String firstName, String lastName, OccupationDto currentPosition,
            SimplifiedWorkerDto supervisor, String room, String stationaryNumber, String mobileNumber) {
        super(id, role, email, firstName, lastName);
        this.currentPosition = currentPosition;
        this.supervisor = supervisor;
        this.room = room;
        this.stationaryNumber = stationaryNumber;
        this.mobileNumber = mobileNumber;
    }

    public OccupationDto getCurrentPosition() {
        return this.currentPosition;
    }

    public SimplifiedWorkerDto getSupervisor() {
        return this.supervisor;
    }

    public String getRoom() {
        return this.room;
    }

    public String getStationaryNumber() {
        return this.stationaryNumber;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setCurrentPosition(OccupationDto currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setSupervisor(SimplifiedWorkerDto supervisor) {
        this.supervisor = supervisor;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setStationaryNumber(String stationaryNumber) {
        this.stationaryNumber = stationaryNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String toString() {
        return "WorkerDto(currentPosition=" + this.getCurrentPosition() + ", supervisor=" + this.getSupervisor() + ", room="
                + this.getRoom() + ", stationaryNumber=" + this.getStationaryNumber() + ", mobileNumber=" + this.getMobileNumber() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this)
            return true;
        if (!(o instanceof WorkerDto))
            return false;
        final WorkerDto other = (WorkerDto) o;
        if (!other.canEqual((Object) this))
            return false;
        if (!super.equals(o))
            return false;
        final Object this$currentPosition = this.getCurrentPosition();
        final Object other$currentPosition = other.getCurrentPosition();
        if (this$currentPosition == null ? other$currentPosition != null : !this$currentPosition.equals(other$currentPosition))
            return false;
        final Object this$supervisor = this.getSupervisor();
        final Object other$supervisor = other.getSupervisor();
        if (this$supervisor == null ? other$supervisor != null : !this$supervisor.equals(other$supervisor))
            return false;
        final Object this$room = this.getRoom();
        final Object other$room = other.getRoom();
        if (this$room == null ? other$room != null : !this$room.equals(other$room))
            return false;
        final Object this$stationaryNumber = this.getStationaryNumber();
        final Object other$stationaryNumber = other.getStationaryNumber();
        if (this$stationaryNumber == null ? other$stationaryNumber != null : !this$stationaryNumber.equals(other$stationaryNumber))
            return false;
        final Object this$mobileNumber = this.getMobileNumber();
        final Object other$mobileNumber = other.getMobileNumber();
        if (this$mobileNumber == null ? other$mobileNumber != null : !this$mobileNumber.equals(other$mobileNumber))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof WorkerDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        final Object $currentPosition = this.getCurrentPosition();
        result = result * PRIME + ($currentPosition == null ? 43 : $currentPosition.hashCode());
        final Object $supervisor = this.getSupervisor();
        result = result * PRIME + ($supervisor == null ? 43 : $supervisor.hashCode());
        final Object $room = this.getRoom();
        result = result * PRIME + ($room == null ? 43 : $room.hashCode());
        final Object $stationaryNumber = this.getStationaryNumber();
        result = result * PRIME + ($stationaryNumber == null ? 43 : $stationaryNumber.hashCode());
        final Object $mobileNumber = this.getMobileNumber();
        result = result * PRIME + ($mobileNumber == null ? 43 : $mobileNumber.hashCode());
        return result;
    }

}

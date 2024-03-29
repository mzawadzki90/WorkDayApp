package michal.zawadzki.workdayapp.api.leave;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import michal.zawadzki.workdayapp.api.MetaDto;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
public class LeaveRequestsDto {

    private MetaDto meta;

    @JsonProperty("leave_requests")
    private List<LeaveRequestDto> leaveRequests;

}

package michal.zawadzki.workdayapp.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import michal.zawadzki.workdayapp.model.leave.LeaveType;
import javax.validation.constraints.NotNull;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class LeaveRequestDto {

    @NotNull
    private LeaveType type;

    @NotNull
    private Date since;

    @NotNull
    private Date till;

    @NotNull
    private int days;

    @JsonProperty("replacement_id")
    private Integer replacementId;

}
package softlab.test.task.models;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ApiErrorResponse<Content> extends ApiResponse<Content> {

    private String error;

    @JsonCreator
    public ApiErrorResponse(
            @JsonProperty("content") Content content,
            @JsonProperty("error") String error
    ) {
        super(content);
        this.error = error;
    }
}
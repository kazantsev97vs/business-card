package softlab.test.task.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Setter @Getter
public class ApiResponse <Content> extends RepresentationModel<ApiResponse<Content>> {

    private Content content;

    @JsonCreator
    public ApiResponse(@JsonProperty("content") Content content) {
        this.content = content;
    }
}
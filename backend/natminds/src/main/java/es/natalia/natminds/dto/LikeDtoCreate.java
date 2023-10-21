package es.natalia.natminds.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import es.natalia.natminds.model.Post;
import es.natalia.natminds.model.User;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class LikeDtoCreate {
    @NotNull
    private User userId;
    @NotNull
    private Post postId;
}

package es.natalia.natminds.apiRest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.Instant;

/*DTO para la funcionalidad de Create (@POST)
 *
 * En este caso CommentDtoCreate tendrá los mismos atributos que la clase Comment menos el id, ya que este se genera de
 * forma automática, por tanto para crear un usuario no hace falta especificar el id. */
@Data
public class CommentDtoCreate {
    @NotNull
    private Long userId;
    @NotNull
    private Long postId;
    @NotBlank
    private String commentText;
    @NotNull
    @JsonProperty("comment_date")
    private Instant commentDate;
}

package es.natalia.natminds.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.natalia.natminds.model.Post;
import es.natalia.natminds.model.User;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/*DTO para la funcionalidad de Create (@GET)
 *
 * En este caso LikeDto tendrá los mismos atributos que la clase Like, ya que queremos recuperar todos los campos. */
@Data
public class LikeDto {
    @JsonProperty("like_id")
    private Long likeId;
    @NotNull
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonProperty("user_id")
    private User userId;
    @NotNull
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonProperty("post_id")
    private Post postId;
}

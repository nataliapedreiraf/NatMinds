package es.natalia.natminds.apiRest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.Instant;

/*DTO para la funcionalidad de Create (@GET)
 *
 * En este caso CommentDto tendrá los mismos atributos que la clase Comment, ya que queremos recuperar todos los campos. */
@Data
public class CommentDto {
    @JsonProperty("comment_id")
    private Long commentId;
    @NotNull
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonProperty("user_id")
    private Long userId;
    @NotNull
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonProperty("post_id")
    private Long postId;
    @JsonProperty("comment_text")
    @NotBlank
    private String commentText;
    @NotNull
    @JsonProperty("comment_date")
    private Instant commentDate;
}

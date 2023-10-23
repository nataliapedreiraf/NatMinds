package es.natalia.natminds.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import es.natalia.natminds.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/*DTO para la funcionalidad de Create (@GET)
 *
 * En este caso PostDto tendrá los mismos atributos que la clase Post, ya que queremos recuperar todos los campos. */
@Data
public class PostDto {
    private Long postId;
    @NotNull
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User userId;
    @NotBlank
    private String text;

}

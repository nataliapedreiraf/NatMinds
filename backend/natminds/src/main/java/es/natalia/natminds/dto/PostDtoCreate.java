package es.natalia.natminds.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import es.natalia.natminds.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/*DTO para la funcionalidad de Create (@POST)
 *
 * En este caso PostDtoCreate tendrá los mismos atributos que la clase Post menos el id, ya que este se genera de
 * forma automática, por tanto para crear un usuario no hace falta especificar el id. */
@Data
public class PostDtoCreate {
    @NotBlank
    private String text;
    @NotNull
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Long userId;
}

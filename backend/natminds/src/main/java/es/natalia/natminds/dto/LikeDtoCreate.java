package es.natalia.natminds.dto;

import es.natalia.natminds.model.Post;
import es.natalia.natminds.model.User;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/*DTO para la funcionalidad de Create (@POST)
 *
 * En este caso LikeDtoCreate tendrá los mismos atributos que la clase Like menos el id, ya que este se genera de
 * forma automática, por tanto para crear un usuario no hace falta especificar el id. */
@Data
public class LikeDtoCreate {
    @NotNull
    private User userId;
    @NotNull
    private Post postId;
}

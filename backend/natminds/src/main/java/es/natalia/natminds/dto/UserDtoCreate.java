package es.natalia.natminds.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/*DTO para la funcionalidad de Create (@POST)
 *
 * En este caso UserDtoCreate tendrá los mismos atributos que la clase User menos el id, ya que este se genera de
 * forma automática, por tanto para crear un usuario no hace falta especificar el id. */
@Data
public class UserDtoCreate {
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    private String userName;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
    private String biography;
}

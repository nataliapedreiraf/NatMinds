package es.natalia.natminds.apiRest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/*DTO para la funcionalidad de Update (@PUT)
 *
 * En este caso UserDtoUpdate tendrá los mismos atributos que la clase User menos el id, ya que este se genera de
 * forma automática, por tanto para crear un usuario no hace falta especificar el id.
 * En este caso los atributos no podrán ser nulos, ya que será una modificación completa. */
@Data
public class UserDtoUpdate {
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

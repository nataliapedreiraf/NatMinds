package es.natalia.natminds.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

/*DTO para la funcionalidad de Partial Update (@PATCH)
 *
 * En este caso UserDtoPartialUpdate tendrá los mismos atributos que la clase User menos el id, ya que este se genera de
 * forma automática, por tanto para crear un usuario no hace falta especificar el id.
 * En este caso los atributos podrán ser nulos, ya que puede que no los modifiquemos todos. */
@Data
public class UserDtoPartialUpdate {
    private String name;
    private String lastName;
    private String userName;
    @Email
    private String email;
    private String password;
    private String biography;
}

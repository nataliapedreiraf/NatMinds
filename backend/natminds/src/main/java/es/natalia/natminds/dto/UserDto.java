package es.natalia.natminds.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/*DTO significa Data Transfer Object. Este patrón tiene como finalidad la creación de objetos planos (POJO) con una
* serie de atributos que pueden ser enviados o recuperados del servidor. De esta forma no utilizaremos directamente
* las clases que van a la BBDD. Así aseguramos que no haya problemas con el flujo de información, y en caso de que
* necesitemos hacer algún tipo de modificación no nos afectará a la BBDD.
*
* DTO para la funcionalidad de Create (@GET)
*
* En este caso UserDTO tendrá los mismos atributos que la clase User, ya que queremos recuperar todos los campos. */
@Data
public class UserDto {
    private Long userId;
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

package es.natalia.natminds.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

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

package es.natalia.natminds.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PostDtoPartialUpdate {
    private String text;
}

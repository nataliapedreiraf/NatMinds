package es.natalia.natminds.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import es.natalia.natminds.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PostDtoCreate {
    @NotBlank
    private String text;
    @NotNull
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User userId;
}

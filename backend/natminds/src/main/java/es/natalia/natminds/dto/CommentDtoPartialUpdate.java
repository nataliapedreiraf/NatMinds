package es.natalia.natminds.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;

@Data
public class CommentDtoPartialUpdate {
    @NotBlank
    private String commentText;
    @NotNull
    @JsonProperty("comment_date")
    private Instant commentDate;
}

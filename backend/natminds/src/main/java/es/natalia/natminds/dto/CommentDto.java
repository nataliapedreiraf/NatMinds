package es.natalia.natminds.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.natalia.natminds.model.Post;
import es.natalia.natminds.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;

@Data
public class CommentDto {
    @JsonProperty("comment_id")
    private Long commentId;
    @NotNull
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonProperty("user_id")
    private User userId;
    @NotNull
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonProperty("post_id")
    private Post postId;
    @JsonProperty("comment_text")
    @NotBlank
    private String commentText;
    @NotNull
    @JsonProperty("comment_date")
    private Instant commentDate;
}

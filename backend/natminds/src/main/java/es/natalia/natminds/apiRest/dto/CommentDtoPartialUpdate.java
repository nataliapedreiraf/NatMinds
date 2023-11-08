package es.natalia.natminds.apiRest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.Instant;

/*DTO para la funcionalidad de Partial Update (@PATCH)
 *
 * En este caso CommentDtoPartialUpdate tendrá los atributos text y date, ya que es lo único que nos podría interesar
 * modificar */
@Data
public class CommentDtoPartialUpdate {
    @JsonProperty("comment_text")
    private String commentText;
    @JsonProperty("comment_date")
    private Instant commentDate;
}

package es.natalia.natminds.model.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.Instant;

/*Creamos la clase Comment con sus correspondientes atributos. Esta clase va a generar nuestra tabla en la BBDD.
 * Con @Data se generan automáticamente Getters/Setters, toString, EqualsAndHashCode y RequiredArgsConstructor. */
@Data
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Post postId;

    @NotBlank
    private String commentText;

    @NotNull
    @Column(name = "comment_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Instant commentDate;
}

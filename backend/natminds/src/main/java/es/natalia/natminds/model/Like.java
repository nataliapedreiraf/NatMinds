package es.natalia.natminds.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

/*Creamos la clase Like con sus correspondientes atributos. Esta clase va a generar nuestra tabla en la BBDD.
 * Con @Data se generan automáticamente Getters/Setters, toString, EqualsAndHashCode y RequiredArgsConstructor. */
@Data
@Entity
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Post postId;
}

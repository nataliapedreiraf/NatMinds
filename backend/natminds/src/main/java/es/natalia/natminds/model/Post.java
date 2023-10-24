package es.natalia.natminds.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*Creamos la clase Post con sus correspondientes atributos. Esta clase va a generar nuestra tabla en la BBDD.
 * Con @Data se generan automáticamente Getters/Setters, toString, EqualsAndHashCode y RequiredArgsConstructor. */

@Data
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    //@NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User userId;
    @NotBlank
    private String text;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "likes",
            joinColumns = { @JoinColumn(name = "post_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    List<User> users = new ArrayList<>();
}

package es.natalia.natminds.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*Creamos la clase User con sus correspondientes atributos. Esta clase va a generar nuestra tabla en la BBDD.
* Con @Data se generan automáticamente Getters/Setters, toString, EqualsAndHashCode y RequiredArgsConstructor. */

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    @Column(unique = true)
    private String userName;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
    private String biography;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "follow",
            joinColumns = { @JoinColumn(name = "user_a") },
            inverseJoinColumns = { @JoinColumn(name = "user_b") }
    )
    List<User> followed = new ArrayList<>();


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "follow",
            joinColumns = { @JoinColumn(name = "user_b") },
            inverseJoinColumns = { @JoinColumn(name = "user_a") }
    )
    List<User> followers = new ArrayList<>();


}


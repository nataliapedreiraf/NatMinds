package es.natalia.natminds.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

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
}


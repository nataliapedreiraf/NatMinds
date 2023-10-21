package es.natalia.natminds.specification;

import es.natalia.natminds.model.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {
    public UserSpecification(){}

    public static Specification<User> byName(String name) {
        return (root, query, builder) -> {
            return builder.like(root.get("name"), "%" + name + "%");
        };
    }

    public static Specification<User> byLastName(String lastName) {
        return (root, query, builder) -> {
            return builder.like(root.get("lastName"), "%" + lastName + "%");
        };
    }

    public static Specification<User> byUserName(String userName) {
        return (root, query, builder) -> {
            return builder.like(root.get("userName"), "%" + userName + "%");
        };
    }

    public static Specification<User> byEmail(String email) {
        return (root, query, builder) -> {
            return builder.like(root.get("email"), "%" + email + "%");
        };
    }

    public static Specification<User> byBiography(String biography) {
        return (root, query, builder) -> {
            return builder.like(root.get("biography"), "%" + biography + "%");
        };
    }
}

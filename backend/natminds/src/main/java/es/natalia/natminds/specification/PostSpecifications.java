package es.natalia.natminds.specification;

import es.natalia.natminds.model.Comment;
import es.natalia.natminds.model.Post;
import org.springframework.data.jpa.domain.Specification;

public class PostSpecifications {
    public PostSpecifications(){}

    public static Specification<Post> byPostUserId(Long userId) {
        return (root, query, builder) -> {
            return builder.like(root.get("userId"), "%" + userId + "%");
        };
    }

    public static Specification<Post> byPostText(String text) {
        return (root, query, builder) -> {
            return builder.like(root.get("text"), "%" + text + "%");
        };
    }
}

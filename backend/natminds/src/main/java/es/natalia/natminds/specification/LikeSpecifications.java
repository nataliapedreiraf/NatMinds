package es.natalia.natminds.specification;

import es.natalia.natminds.model.Like;
import org.springframework.data.jpa.domain.Specification;
public class LikeSpecifications {
    public LikeSpecifications(){}

    public static Specification<Like> byLikeUserId(Long userId) {
        return (root, query, builder) -> {
            return builder.like(root.get("userId"), "%" + userId + "%");
        };
    }

    public static Specification<Like> byLikePostId(Long postId) {
        return (root, query, builder) -> {
            return builder.like(root.get("postId"), "%" + postId + "%");
        };
    }
}

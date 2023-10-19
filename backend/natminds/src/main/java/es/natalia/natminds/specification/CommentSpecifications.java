package es.natalia.natminds.specification;

import es.natalia.natminds.model.Comment;
import org.springframework.data.jpa.domain.Specification;

import java.time.Instant;

public class CommentSpecifications {
    public CommentSpecifications(){}

    public static Specification<Comment> byCommentUserId(Long userId) {
        return (root, query, builder) -> {
            return builder.like(root.get("userId"), "%" + userId + "%");
        };
    }

    public static Specification<Comment> byCommentPostId(Long postId) {
        return (root, query, builder) -> {
            return builder.like(root.get("postId"), "%" + postId + "%");
        };
    }

    public static Specification<Comment> byCommentText(String commentText) {
        return (root, query, builder) -> {
            return builder.like(root.get("commentText"), "%" + commentText + "%");
        };
    }

    public static Specification<Comment> byCommentDate(Instant commentDate) {
        return (root, query, builder) -> {
            return builder.equal(root.get("commentDate"), commentDate);
        };
    }
}

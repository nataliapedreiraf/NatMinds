package es.natalia.natminds.model.repository;

import es.natalia.natminds.model.model.Comment;
import org.springframework.data.jpa.domain.Specification;

import java.time.Instant;

/*Creamos la clase Specification para el comment. Aquí vamos a definir una serie de especificaciones que luego usaremos
 * para poder hacer búsquedas filtradas por atributos. Utilizamos funciones lambda para definir aquello por lo que
 * vamos a querer filtrar y que por tanto necesitaremos comparar con la información que hay en BBDD.*/
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

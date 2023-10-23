package es.natalia.natminds.specification;

import es.natalia.natminds.model.Like;
import org.springframework.data.jpa.domain.Specification;

/*Creamos la clase Specification para el like. Aquí vamos a definir una serie de especificaciones que luego usaremos
 * para poder hacer búsquedas filtradas por atributos. Utilizamos funciones lambda para definir aquello por lo que
 * vamos a querer filtrar y que por tanto necesitaremos comparar con la información que hay en BBDD.*/

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

package es.natalia.natminds.repository;

import es.natalia.natminds.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/*Creamos el repositorio de la clase Comment. Este repositorio extiende JpaRepository y JpaSpecificationExecutor.*/
public interface CommentRepository
        extends JpaRepository<Comment, Long>, JpaSpecificationExecutor<Comment> {

}

package es.natalia.natminds.model.repository;

import es.natalia.natminds.model.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/*Creamos el repositorio de la clase Post. Este repositorio extiende JpaRepository y JpaSpecificationExecutor.*/
public interface PostRepository
        extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {

}

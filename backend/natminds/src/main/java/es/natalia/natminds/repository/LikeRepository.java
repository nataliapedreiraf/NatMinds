package es.natalia.natminds.repository;

import es.natalia.natminds.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/*Creamos el repositorio de la clase Like. Este repositorio extiende JpaRepository y JpaSpecificationExecutor.*/
public interface LikeRepository
        extends JpaRepository<Like, Long>, JpaSpecificationExecutor<Like> {

}

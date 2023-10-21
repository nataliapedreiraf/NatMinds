package es.natalia.natminds.repository;

import es.natalia.natminds.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LikeRepository
        extends JpaRepository<Like, Long>, JpaSpecificationExecutor<Like> {

}

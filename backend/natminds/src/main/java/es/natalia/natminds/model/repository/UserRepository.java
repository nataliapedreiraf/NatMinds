package es.natalia.natminds.model.repository;

import es.natalia.natminds.model.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/*Creamos el repositorio de la clase User. Este repositorio extiende JpaRepository y JpaSpecificationExecutor,
* JpaRepository es una interfaz creada por Spring Data que nos facilita la forma de administrar los datos de nuestra
* BBDD.
* JpaSpecificationExecutor añade  al repositorio métodos de búsqueda que reciben un argumento de tipo Specification.*/
public interface UserRepository
        extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {}

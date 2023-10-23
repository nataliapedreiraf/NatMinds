package es.natalia.natminds.service;

import es.natalia.natminds.dto.LikeDto;
import es.natalia.natminds.model.Like;
import java.util.List;

/*Creamos la interfaz Service para el Like. Aquí especificamos todos los métodos que vamos a necesitar para la
 * lógica de negocio.*/
public interface LikeService {
    public Like getLike(Long likeId);
    public Like createLike(Like like);
    public void removeLike(Long likeId);
    public List<Like> findAll();
    List<LikeDto> findLikes(Long postId, Long userId);

}

package es.natalia.natminds.service;

import es.natalia.natminds.dto.CommentDto;
import es.natalia.natminds.model.Comment;
import javax.management.InstanceNotFoundException;
import java.time.Instant;
import java.util.List;

/*Creamos la interfaz Service para el Comment. Aquí especificamos todos los métodos que vamos a necesitar para la
 * lógica de negocio.*/
public interface CommentService {
    public Comment getComment(Long commentId);

    public Comment createComment(Comment comment);
    public void removeComment(Long commentId);

    List<CommentDto> findComments(Long postId, Long userId, String commentText, Instant commentDate);

    public void partialUpdateComment(Long commentId, Comment comment) throws InstanceNotFoundException;
}

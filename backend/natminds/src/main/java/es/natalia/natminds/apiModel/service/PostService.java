package es.natalia.natminds.apiModel.service;

import es.natalia.natminds.apiRest.dto.PostDto;
import es.natalia.natminds.model.model.Post;
import javax.management.InstanceNotFoundException;
import java.util.List;

/*Creamos la interfaz Service para el Post. Aquí especificamos todos los métodos que vamos a necesitar para la
 * lógica de negocio.*/
public interface PostService {
    public Post getPost(Long postId);

    public Post createPost(Post post);
    public void removePost(Long postId);

    List<PostDto> findPosts(Long userId, String text);

    public void partialUpdatePost(Long postId, Post post) throws InstanceNotFoundException;
}

package es.natalia.natminds.service;

import es.natalia.natminds.dto.PostDto;
import es.natalia.natminds.model.Post;
import es.natalia.natminds.model.User;

import javax.management.InstanceNotFoundException;
import java.util.List;

public interface PostService {
    public Post getPost(Long postId);

    public Post createPost(Post post);
    public void removePost(Long postId);
    public List<Post> findAll();
    List<PostDto> findPosts(Long userId, String text);

    public void partialUpdatePost(Long postId, Post post) throws InstanceNotFoundException;
}

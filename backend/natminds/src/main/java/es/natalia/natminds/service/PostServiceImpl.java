package es.natalia.natminds.service;

import es.natalia.natminds.dto.PostDto;
import es.natalia.natminds.mapper.PostMapper;
import es.natalia.natminds.model.Post;
import es.natalia.natminds.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.Optional;

import static es.natalia.natminds.specification.PostSpecifications.*;

@Service
@Transactional
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;
    @Autowired
    PostMapper postMapper;
    
    @Override
    public Post getPost(Long postId) {
        Optional<Post> postEntity = postRepository.findById(postId);
        return postEntity.get();
    }



    @Override
    public Post createPost(Post post) {

        return postRepository.save(post);
    }

    @Override
    public void removePost(Long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public List<Post> findAll() {

        return postRepository.findAll();
    }

    @Override
    public List<PostDto> findPosts(Long userId, String text) {
        Specification<Post> filters = Specification.where(userId == null ? null : byPostUserId(userId))
                .and(text == null ? null : byPostText(text));


        return postRepository.findAll(filters)
                .stream()
                .map(postMapper::postToDto)
                .toList();
    }

    @Override
    public void partialUpdatePost(Long postId, Post newPost) throws InstanceNotFoundException {
        Optional<Post> postOptional = postRepository.findById(postId);
        if (postOptional.isEmpty()) throw new InstanceNotFoundException();

        Post post = postOptional.get();

        if(newPost.getText() != null){
            post.setText(newPost.getText());
        }
    }
}
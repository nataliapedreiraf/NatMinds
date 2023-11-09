package es.natalia.natminds.apiRest.rest;

import es.natalia.natminds.apiRest.dto.PostDto;
import es.natalia.natminds.apiRest.dto.PostDtoCreate;
import es.natalia.natminds.apiRest.dto.PostDtoPartialUpdate;
import es.natalia.natminds.apiRest.mapper.PostMapper;
import es.natalia.natminds.apiModel.service.PostService;
import es.natalia.natminds.model.model.Post;
import es.natalia.natminds.model.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.management.InstanceNotFoundException;
import java.util.List;

/*Creamos el controlador del post. Aquí definiremos todos los endpoints que necesitamos para el funcionamiento de
 * nuestra aplicación.*/
@RestController
public class PostController {
    @Autowired
    private PostService postService;

    private Post post;

    // POST
    @PostMapping("/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody @Valid PostDtoCreate postDtoCreate){
        Post post = new Post();

        User user = new User();
        user.setUserId(postDtoCreate.getUserId());
        post.setUserId(user);

        post.setText(postDtoCreate.getText());

        postService.createPost(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPost(@PathVariable Long postId) {

        PostDto postDto = new PostDto();
        postDto.setPostId(post.getPostId());
        postDto.setUserId(post.getUserId().getUserId());
        postDto.setText(post.getText());

        postService.getPost(postId);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/posts/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<PostDto> removePost (@PathVariable Long postId){
        postService.removePost((postId));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/posts/filter")
    public List<PostDto> findPosts(
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) String text){

        return  postService.findPosts(userId, text);
    }

    @PatchMapping("/posts/{postId}")
    public ResponseEntity<PostDto> postPartialUpdate(@PathVariable Long postId,
                                                     @RequestBody @Valid PostDtoPartialUpdate postDtoPartialUpdate) throws InstanceNotFoundException {
        Post post = new Post();
        post.setText(postDtoPartialUpdate.getText());

        postService.partialUpdatePost(postId, post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

package es.natalia.natminds.rest;

import es.natalia.natminds.dto.*;
import es.natalia.natminds.mapper.PostMapper;
import es.natalia.natminds.model.Post;
import es.natalia.natminds.service.PostService;
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
    private PostMapper postMapper;
    @Autowired
    private PostService postService;

    // POST
    @PostMapping("/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody @Valid PostDtoCreate postDtoCreate){
        postService.createPost(postMapper.dtoCreateToPost(postDtoCreate));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPost(@PathVariable Long postId) {
        return new ResponseEntity<>(postMapper.postToDto(postService.getPost(postId)), HttpStatus.OK);
    }

    @GetMapping("/posts/all")
    public List<Post> getAllPosts(){
        return postService.findAll();
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
        postService.partialUpdatePost(postId, postMapper.dtoPartialUpdateToPost(postDtoPartialUpdate));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

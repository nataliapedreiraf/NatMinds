package es.natalia.natminds.apiRest.rest;

import es.natalia.natminds.apiRest.dto.CommentDto;
import es.natalia.natminds.apiRest.dto.CommentDtoCreate;
import es.natalia.natminds.apiRest.dto.CommentDtoPartialUpdate;
import es.natalia.natminds.apiRest.mapper.CommentMapper;
import es.natalia.natminds.apiModel.service.CommentService;
import es.natalia.natminds.model.model.Comment;
import es.natalia.natminds.model.model.Post;
import es.natalia.natminds.model.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.management.InstanceNotFoundException;
import java.time.Instant;
import java.util.List;

/*Creamos el controlador del comment. Aquí definiremos todos los endpoints que necesitamos para el funcionamiento de
 * nuestra aplicación.*/
@RestController
@ComponentScan(basePackages = "es.natalia.natminds.apiRest.mapper")
public class CommentController {
    @Autowired
    private CommentService commentService;

    private Comment comment;

    // POST
    @PostMapping("/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody @Valid CommentDtoCreate commentDtoCreate){
        Comment comment = new Comment();
        comment.setCommentDate(commentDtoCreate.getCommentDate());
        comment.setCommentText(commentDtoCreate.getCommentText());

        User user = new User();
        user.setUserId(commentDtoCreate.getUserId());
        comment.setUserId(user);

        Post post = new Post();
        post.setPostId(commentDtoCreate.getPostId());
        comment.setPostId(post);

        commentService.createComment(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/comments/{commentId}")
    public ResponseEntity<CommentDto> getComment(@PathVariable Long commentId) {

        CommentDto commentDto = new CommentDto();
        commentDto.setCommentId(comment.getCommentId());
        commentDto.setUserId(comment.getUserId().getUserId());
        commentDto.setPostId(comment.getPostId().getPostId());
        commentDto.setCommentText(comment.getCommentText());
        commentDto.setCommentDate(comment.getCommentDate());

        commentService.getComment(commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/comments/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<CommentDto> removeComment (@PathVariable Long commentId){
        commentService.removeComment(commentId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/comments/filter")
    public List<CommentDto> findComments(
            @RequestParam(required = false) Long postId,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) String commentText,
            @RequestParam(required = false) Instant commentDate){

        return  commentService.findComments(postId, userId, commentText, commentDate);
    }

    @PatchMapping("/comments/{commentId}")
    public ResponseEntity<CommentDto> commentPartialUpdate(@PathVariable Long commentId,
                                                     @RequestBody @Valid CommentDtoPartialUpdate commentDtoPartialUpdate) throws InstanceNotFoundException {
        Comment comment = new Comment();
        comment.setCommentText(commentDtoPartialUpdate.getCommentText());
        comment.setCommentDate(commentDtoPartialUpdate.getCommentDate());


        commentService.partialUpdateComment(commentId, comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

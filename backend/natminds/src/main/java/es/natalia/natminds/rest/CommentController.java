package es.natalia.natminds.rest;

import es.natalia.natminds.dto.*;
import es.natalia.natminds.mapper.CommentMapper;
import es.natalia.natminds.model.Comment;
import es.natalia.natminds.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.management.InstanceNotFoundException;
import java.time.Instant;
import java.util.List;

/*Creamos el controlador del comment. Aquí definiremos todos los endpoints que necesitamos para el funcionamiento de
 * nuestra aplicación.*/
@RestController
public class CommentController {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentService commentService;

    // POST
    @PostMapping("/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody @Valid CommentDtoCreate commentDtoCreate){
        commentService.createComment(commentMapper.dtoCreateToComment(commentDtoCreate));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/comments/{commentId}")
    public ResponseEntity<CommentDto> getComment(@PathVariable Long commentId) {
        return new ResponseEntity<>(commentMapper.commentToDto(commentService.getComment(commentId)), HttpStatus.OK);
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
        commentService.partialUpdateComment(commentId, commentMapper.dtoPartialUpdateToComment(commentDtoPartialUpdate));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

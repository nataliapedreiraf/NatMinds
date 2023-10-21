package es.natalia.natminds.rest;

import es.natalia.natminds.dto.*;
import es.natalia.natminds.mapper.CommentMapper;
import es.natalia.natminds.mapper.LikeMapper;
import es.natalia.natminds.model.Comment;
import es.natalia.natminds.model.Like;
import es.natalia.natminds.service.CommentService;
import es.natalia.natminds.service.LikeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.management.InstanceNotFoundException;
import java.time.Instant;
import java.util.List;

@RestController
public class LikeController {
    @Autowired
    private LikeMapper likeMapper;
    @Autowired
    private LikeService likeService;

    // POST
    @PostMapping("/likes")
    public ResponseEntity<LikeDto> createLike(@RequestBody @Valid LikeDtoCreate likeDtoCreate){
        likeService.createLike(likeMapper.dtoCreateToLike(likeDtoCreate));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/likes/{likeId}")
    public ResponseEntity<LikeDto> getLike(@PathVariable Long likeId) {
        return new ResponseEntity<>(likeMapper.likeToDto(likeService.getLike(likeId)), HttpStatus.OK);
    }

    @GetMapping("/likes/all")
    public List<Like> getAllLikes(){
        return likeService.findAll();
    }

    @DeleteMapping("/likes/{likeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<LikeDto> removeLike (@PathVariable Long likeId){
        likeService.removeLike(likeId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/likes/filter")
    public List<LikeDto> findLikes(
            @RequestParam(required = false) Long postId,
            @RequestParam(required = false) Long userId){

        return  likeService.findLikes(postId, userId);
    }

}

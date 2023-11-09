package es.natalia.natminds.model.service;

import es.natalia.natminds.apiRest.dto.CommentDto;
import es.natalia.natminds.apiRest.mapper.CommentMapper;
import es.natalia.natminds.model.model.Comment;
import es.natalia.natminds.model.repository.CommentRepository;
import es.natalia.natminds.apiModel.service.CommentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.management.InstanceNotFoundException;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import static es.natalia.natminds.model.repository.CommentSpecifications.*;

/*Creamos la implementación del service comment. Aquí tendremos la lógica de negocio y especificamos que tiene que hacer
 * cada uno de los métodos que vamos a utilizar.*/
@Service
@Transactional
@ComponentScan(basePackages = "es.natalia.natminds.apiRest.mapper")
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    CommentMapper commentMapper;
    @Override
    public Comment getComment(Long commentId) {
        Optional<Comment> commentEntity = commentRepository.findById(commentId);
        return commentEntity.get();
    }

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void removeComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }



    @Override
    public List<CommentDto> findComments(Long postId, Long userId, String commentText, Instant commentDate) {
        Specification<Comment> filters = Specification.where(postId == null ? null : byCommentPostId(postId))
                .and(userId == null ? null : byCommentUserId(userId))
                .and(commentText == null ? null : byCommentText(commentText))
                .and(commentDate == null ? null : byCommentDate(commentDate));


        return commentRepository.findAll(filters)
                .stream()
                .map(commentMapper::commentToDto)
                .toList();
    }

    @Override
    public void partialUpdateComment(Long commentId, Comment newComment) throws InstanceNotFoundException {
        Optional<Comment> commentOptional = commentRepository.findById(commentId);
        if (commentOptional.isEmpty()) throw new InstanceNotFoundException();

        Comment comment = commentOptional.get();

        if(newComment.getCommentText() != null){
            comment.setCommentText(newComment.getCommentText());
        }

        if(newComment.getCommentDate() != null){
            comment.setCommentDate(newComment.getCommentDate());
        }
    }
}

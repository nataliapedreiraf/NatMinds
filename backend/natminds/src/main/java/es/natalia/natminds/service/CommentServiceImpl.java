package es.natalia.natminds.service;

import es.natalia.natminds.dto.CommentDto;
import es.natalia.natminds.mapper.CommentMapper;
import es.natalia.natminds.model.Comment;
import es.natalia.natminds.repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static es.natalia.natminds.specification.CommentSpecifications.*;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{

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
    public List<Comment> findAll() {
        return commentRepository.findAll();
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

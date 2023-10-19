package es.natalia.natminds.service;

import es.natalia.natminds.dto.CommentDto;
import es.natalia.natminds.model.Comment;
import javax.management.InstanceNotFoundException;
import java.time.Instant;
import java.util.List;

public interface CommentService {
    public Comment getComment(Long commentId);

    public Comment createComment(Comment comment);
    public void removeComment(Long commentId);
    public List<Comment> findAll();
    List<CommentDto> findComments(Long postId, Long userId, String commentText, Instant commentDate);

    public void partialUpdateComment(Long commentId, Comment comment) throws InstanceNotFoundException;
}

package es.natalia.natminds.apiRest.mapper;

import es.natalia.natminds.apiRest.dto.CommentDto;
import es.natalia.natminds.apiRest.dto.CommentDtoCreate;
import es.natalia.natminds.apiRest.dto.CommentDtoPartialUpdate;
import es.natalia.natminds.apiRest.dto.PostDto;
import es.natalia.natminds.apiRest.dto.PostDtoCreate;
import es.natalia.natminds.apiRest.dto.PostDtoPartialUpdate;
import es.natalia.natminds.model.model.Comment;
import es.natalia.natminds.model.model.Post;
import es.natalia.natminds.model.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

/*Creamos la clase CommentMapper para hacer las transformaciones entre la clase Comment y sus respectivas clases DTO
 * utilizando mapstruct*/

//@Mapper(componentModel = "spring")
//@Component
public interface CommentMapper {

  public default CommentDto commentToDto(Comment comment) {
    CommentDto commentDto = new CommentDto();
    commentDto.setCommentId(comment.getCommentId());
    commentDto.setUserId(comment.getUserId().getUserId());
    commentDto.setPostId(comment.getPostId().getPostId());
    commentDto.setCommentText(comment.getCommentText());
    commentDto.setCommentDate(comment.getCommentDate());
    return commentDto;
  }

  public default Comment dtoToComment(CommentDto commentDto) {
    Comment comment = new Comment();

    User user = new User();
    user.setUserId(commentDto.getUserId());
    comment.setUserId(user);

    Post post = new Post();
    post.setPostId(commentDto.getPostId());
    comment.setPostId(post);

    comment.setCommentId(commentDto.getPostId());
    comment.setCommentText(commentDto.getCommentText());
    comment.setCommentDate(commentDto.getCommentDate());

    return comment;

  }

  public default CommentDtoCreate commentToDtoCreate(Comment comment) {
    CommentDtoCreate commentDtoCreate = new CommentDtoCreate();

    commentDtoCreate.setUserId(comment.getUserId().getUserId());
    commentDtoCreate.setPostId(comment.getPostId().getPostId());
    commentDtoCreate.setCommentText(comment.getCommentText());
    commentDtoCreate.setCommentText(comment.getCommentText());
    return commentDtoCreate;
  }

  public default Comment dtoCreateToComment(CommentDtoCreate commentDtoCreate) {
    Comment comment = new Comment();
    comment.setCommentDate(commentDtoCreate.getCommentDate());
    comment.setCommentText(commentDtoCreate.getCommentText());

    User user = new User();
    user.setUserId(commentDtoCreate.getUserId());
    comment.setUserId(user);

    Post post = new Post();
    post.setPostId(commentDtoCreate.getPostId());
    comment.setPostId(post);

    return comment;
  }

  public default CommentDtoPartialUpdate commentToDtoPartialUpdate(Comment comment) {
    CommentDtoPartialUpdate commentDtoPartialUpdate = new CommentDtoPartialUpdate();
    commentDtoPartialUpdate.setCommentDate(comment.getCommentDate());
    commentDtoPartialUpdate.setCommentText(comment.getCommentText());
    return commentDtoPartialUpdate;
  }

  public default Comment dtoPartialUpdateToComment(CommentDtoPartialUpdate commentDtoPartialUpdate) {
    Comment comment = new Comment();
    comment.setCommentText(commentDtoPartialUpdate.getCommentText());
    comment.setCommentDate(commentDtoPartialUpdate.getCommentDate());

    return comment;
  }




 /*
    Comment dtoToComment(CommentDto commentDto);

    CommentDto commentToDto(Comment comment);

    // Comment: Create

    Comment dtoCreateToComment(CommentDtoCreate commentDtoCreate);
    CommentDtoCreate commentToDtoCreate(Comment comment);

    // Comment: PartialUpdate

    Comment dtoPartialUpdateToComment(CommentDtoPartialUpdate commentDtoPartialUpdate);
    CommentDtoPartialUpdate commentToDtoPartialUpdate(Comment comment);*/

}

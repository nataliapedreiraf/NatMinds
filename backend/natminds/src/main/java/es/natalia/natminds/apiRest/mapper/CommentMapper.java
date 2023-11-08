package es.natalia.natminds.apiRest.mapper;

import es.natalia.natminds.apiRest.dto.CommentDto;
import es.natalia.natminds.apiRest.dto.CommentDtoCreate;
import es.natalia.natminds.apiRest.dto.CommentDtoPartialUpdate;
import es.natalia.natminds.model.model.Comment;
import es.natalia.natminds.model.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

/*Creamos la clase CommentMapper para hacer las transformaciones entre la clase Comment y sus respectivas clases DTO
 * utilizando mapstruct*/

@Mapper(componentModel = "spring")
public interface CommentMapper {
    // Comment: Dto

    @Named("postToIdPost")
    public static long postToIdPost(Post post) {
        return post.getPostId();
    }
    @Mapping(source = "userId", target = "userId", qualifiedByName = "userToIdUser")
    @Mapping(source = "postId", target = "postId", qualifiedByName = "postToIdPost")
    Comment dtoToComment(CommentDto commentDto);

    CommentDto commentToDto(Comment comment);

    // Comment: Create

    Comment dtoCreateToComment(CommentDtoCreate commentDtoCreate);
    CommentDtoCreate commentToDtoCreate(Comment comment);

    // Comment: PartialUpdate

    Comment dtoPartialUpdateToComment(CommentDtoPartialUpdate commentDtoPartialUpdate);
    CommentDtoPartialUpdate commentToDtoPartialUpdate(Comment comment);

}
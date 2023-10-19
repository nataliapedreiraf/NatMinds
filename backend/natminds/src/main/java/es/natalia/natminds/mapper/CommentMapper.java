package es.natalia.natminds.mapper;

import es.natalia.natminds.dto.*;
import es.natalia.natminds.model.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    // Comment: Dto
    Comment dtoToComment(CommentDto commentDto);
    CommentDto commentToDto(Comment comment);

    // Comment: Create
    Comment dtoCreateToComment(CommentDtoCreate commentDtoCreate);
    CommentDtoCreate commentToDtoCreate(Comment comment);

    // Comment: PartialUpdate
    Comment dtoPartialUpdateToComment(CommentDtoPartialUpdate commentDtoPartialUpdate);
    CommentDtoPartialUpdate commentToDtoPartialUpdate(Comment comment);
}

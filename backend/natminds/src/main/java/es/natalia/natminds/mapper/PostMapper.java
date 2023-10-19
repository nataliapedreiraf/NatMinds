package es.natalia.natminds.mapper;

import es.natalia.natminds.dto.*;
import es.natalia.natminds.model.Post;
import es.natalia.natminds.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    // Post: Dto
    Post dtoToPost(PostDto postDto);
    PostDto postToDto(Post post);

    // Post: Create
    Post dtoCreateToPost(PostDtoCreate postDtoCreate);
    PostDtoCreate postToDtoCreate(Post post);

    // Post: PartialUpdate
    Post dtoPartialUpdateToPost(PostDtoPartialUpdate postDtoPartialUpdate);
    PostDtoPartialUpdate postToDtoPartialUpdate(Post post);
}

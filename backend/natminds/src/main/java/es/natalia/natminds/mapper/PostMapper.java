package es.natalia.natminds.mapper;

import es.natalia.natminds.dto.*;
import es.natalia.natminds.model.Post;
import org.mapstruct.Mapper;

/*Creamos la clase PostMapper para hacer las transformaciones entre la clase Post y sus respectivas clases DTO
 * utilizando mapstruct*/

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

package es.natalia.natminds.apiRest.mapper;

import es.natalia.natminds.apiRest.dto.PostDto;
import es.natalia.natminds.apiRest.dto.PostDtoCreate;
import es.natalia.natminds.apiRest.dto.PostDtoPartialUpdate;
import es.natalia.natminds.model.model.Post;
import es.natalia.natminds.model.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

/*Creamos la clase PostMapper para hacer las transformaciones entre la clase Post y sus respectivas clases DTO
 * utilizando mapstruct*/

@Mapper(componentModel = "spring")
public interface PostMapper {
    // Post: Dto
    @Named("userToIdUser")
    public static Long userToIdUser(User user) {
        return user.getUserId();
    }


    Post dtoToPost(PostDto postDto);
    @Mapping(source = "userId", target = "userId", qualifiedByName = "userToIdUser")
    PostDto postToDto(Post post);

    // Post: Create
    Post dtoCreateToPost(PostDtoCreate postDtoCreate);
    PostDtoCreate postToDtoCreate(Post post);

    // Post: PartialUpdate
    Post dtoPartialUpdateToPost(PostDtoPartialUpdate postDtoPartialUpdate);
    PostDtoPartialUpdate postToDtoPartialUpdate(Post post);


}

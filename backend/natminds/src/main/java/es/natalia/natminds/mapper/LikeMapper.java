package es.natalia.natminds.mapper;

import es.natalia.natminds.dto.*;
import es.natalia.natminds.model.Like;
import org.mapstruct.Mapper;

/*Creamos la clase LikeMapper para hacer las transformaciones entre la clase User y sus respectivas clases DTO
 * utilizando mapstruct*/

@Mapper(componentModel = "spring")
public interface LikeMapper {
    // Like: Dto
    Like dtoToLike(LikeDto likeDto);
    LikeDto likeToDto(Like like);

    // Like: Create
    Like dtoCreateToLike(LikeDtoCreate likeDtoCreate);
    LikeDtoCreate likeToDtoCreate(Like like);

}

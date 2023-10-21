package es.natalia.natminds.mapper;

import es.natalia.natminds.dto.*;
import es.natalia.natminds.model.Comment;
import es.natalia.natminds.model.Like;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LikeMapper {
    // Like: Dto
    Like dtoToLike(LikeDto likeDto);
    LikeDto likeToDto(Like like);

    // Like: Create
    Like dtoCreateToLike(LikeDtoCreate likeDtoCreate);
    LikeDtoCreate likeToDtoCreate(Like like);

}

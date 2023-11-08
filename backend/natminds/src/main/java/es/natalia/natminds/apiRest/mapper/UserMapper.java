package es.natalia.natminds.apiRest.mapper;

import es.natalia.natminds.apiRest.dto.UserDto;
import es.natalia.natminds.apiRest.dto.UserDtoCreate;
import es.natalia.natminds.apiRest.dto.UserDtoPartialUpdate;
import es.natalia.natminds.apiRest.dto.UserDtoUpdate;
import es.natalia.natminds.model.model.User;
import org.mapstruct.Mapper;

/*Creamos la clase UserMapper para hacer las transformaciones entre la clase User y sus respectivas clases DTO
* utilizando mapstruct*/

@Mapper(componentModel = "spring")
public interface UserMapper {

    // User: Dto
    User dtoToUser(UserDto userDto);
    UserDto userToDto(User user);

    // User: Create
    User dtoCreateToUser(UserDtoCreate userDtoCreate);
    UserDtoCreate userToDtoCreate(User user);

    // User: PartialUpdate
    User dtoPartialUpdateToUser(UserDtoPartialUpdate userDtoPartialUpdate);
    UserDtoPartialUpdate userToDtoPartialUpdate(User user);

    // User: Update
    User dtoUpdateToUser(UserDtoUpdate userDtoUpdate);
    UserDtoUpdate userToDtoUpdate(User user);
}

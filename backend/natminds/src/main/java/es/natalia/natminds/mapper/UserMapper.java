package es.natalia.natminds.mapper;

import es.natalia.natminds.dto.UserDto;
import es.natalia.natminds.dto.UserDtoCreate;
import es.natalia.natminds.dto.UserDtoPartialUpdate;
import es.natalia.natminds.dto.UserDtoUpdate;
import es.natalia.natminds.model.User;
import org.mapstruct.Mapper;

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

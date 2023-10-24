package es.natalia.natminds.rest;

import es.natalia.natminds.dto.UserDto;
import es.natalia.natminds.dto.UserDtoCreate;
import es.natalia.natminds.dto.UserDtoPartialUpdate;
import es.natalia.natminds.dto.UserDtoUpdate;
import es.natalia.natminds.mapper.UserMapper;
import es.natalia.natminds.model.User;
import es.natalia.natminds.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.management.InstanceNotFoundException;
import java.util.List;

/*Creamos el controlador del user. Aquí definiremos todos los endpoints que necesitamos para el funcionamiento de
* nuestra aplicación.*/
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    // POST
    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDtoCreate userDtoCreate){
        userService.createUser(userMapper.dtoCreateToUser(userDtoCreate));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId) {
        return new ResponseEntity<>(userMapper.userToDto(userService.getUser(userId)), HttpStatus.OK);
    }


    @PutMapping("/users/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long userId, @RequestBody @Valid UserDtoUpdate userDtoUpdate) throws InstanceNotFoundException {
        userService.updateUser(userId, userMapper.dtoUpdateToUser(userDtoUpdate));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/users/{userId}")
    public ResponseEntity<UserDto> userPartialUpdate(@PathVariable Long userId,
                                             @RequestBody @Valid UserDtoPartialUpdate userDtoPartialUpdate) throws InstanceNotFoundException {
        userService.partialUpdateUser(userId, userMapper.dtoPartialUpdateToUser(userDtoPartialUpdate));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<UserDto> removeUser (@PathVariable Long userId){
        userService.removeUser((userId));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/users/filter")
    public List<UserDto> findUsers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String biography){

        return  userService.findUsers(name, lastName, userName, email, biography);
    }

}

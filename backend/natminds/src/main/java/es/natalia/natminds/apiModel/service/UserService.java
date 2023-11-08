package es.natalia.natminds.apiModel.service;

import es.natalia.natminds.apiRest.dto.UserDto;
import es.natalia.natminds.model.model.User;
import javax.management.InstanceNotFoundException;
import java.util.List;

/*Creamos la interfaz Service para el User. Aquí especificamos todos los métodos que vamos a necesitar para la
* lógica de negocio.*/
public interface UserService {
    public User getUser(Long userId);
    public void updateUser(Long userId, User user) throws InstanceNotFoundException;
    public void partialUpdateUser(Long userId, User user) throws InstanceNotFoundException;
    public User createUser(User user);
    public void removeUser(Long userId);
    List<UserDto> findUsers(String name, String lastName, String userName, String email, String biography);
}

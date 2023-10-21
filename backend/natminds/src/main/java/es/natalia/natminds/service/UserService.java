package es.natalia.natminds.service;

import es.natalia.natminds.dto.UserDto;
import es.natalia.natminds.model.User;

import javax.management.InstanceNotFoundException;
import java.util.List;

public interface UserService {
    public User getUser(Long userId);
    public void updateUser(Long userId, User user) throws InstanceNotFoundException;
    public void partialUpdateUser(Long userId, User user) throws InstanceNotFoundException;
    public User createUser(User user);
    public void removeUser(Long userId);
    public List<User> findAll();
    List<UserDto> findUsers(String name, String lastName, String userName, String email, String biography);
}

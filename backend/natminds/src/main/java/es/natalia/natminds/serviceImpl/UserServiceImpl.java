package es.natalia.natminds.serviceImpl;

import es.natalia.natminds.dto.UserDto;
import es.natalia.natminds.mapper.UserMapper;
import es.natalia.natminds.model.User;
import es.natalia.natminds.repository.UserRepository;
import es.natalia.natminds.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.Optional;
import static es.natalia.natminds.specification.UserSpecification.*;

/*Creamos la implementación del service user. Aquí tendremos la lógica de negocio y especificamos que tiene que hacer
* cada uno de los métodos que vamos a utilizar.*/
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;
    @Override
    public User getUser(Long userId) {
        Optional<User> userEntity = userRepository.findById(userId);
        return userEntity.get();
    }

    @Override
    public void updateUser(Long userId, User userEntity) throws InstanceNotFoundException {
        Optional<User> userEntity1 = userRepository.findById(userId);
        if(userEntity1.isEmpty()) throw new InstanceNotFoundException();
        User user = userEntity1.get();
        user.setUserName(userEntity.getUserName());
        user.setName(userEntity.getName());
        user.setLastName(userEntity.getLastName());
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());
    }

    @Override
    public void partialUpdateUser(Long userId, User newUser) throws InstanceNotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) throw new InstanceNotFoundException();

        User user = userOptional.get();

        if(newUser.getName() != null){
            user.setName(newUser.getName());
        }
        if(newUser.getLastName() != null){
            user.setLastName(newUser.getLastName());
        }
        if(newUser.getUserName() != null){
            user.setUserName(newUser.getUserName());
        }
        if(newUser.getEmail() != null){
            user.setEmail(newUser.getEmail());
        }
        if(newUser.getPassword() != null){
            user.setPassword(newUser.getPassword());
        }
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void removeUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<UserDto> findUsers(String name, String lastName, String userName, String email, String biography) {
        Specification<User> filters = Specification.where(name == null ? null : byName(name))
                .and(lastName == null ? null : byLastName(lastName))
                .and(userName == null ? null : byUserName(userName))
                .and((email == null) ? null : byEmail(email))
                .and((biography == null) ? null : byBiography(biography));


        return userRepository.findAll(filters)
                .stream()
                .map(userMapper::userToDto)
                .toList();
    }
}

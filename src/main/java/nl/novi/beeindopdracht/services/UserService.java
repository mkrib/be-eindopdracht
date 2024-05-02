package nl.novi.beeindopdracht.services;

import nl.novi.beeindopdracht.dtos.UserRequestDto;
import nl.novi.beeindopdracht.entities.Profile;
import nl.novi.beeindopdracht.entities.Role;
import nl.novi.beeindopdracht.entities.User;
import nl.novi.beeindopdracht.mappers.ProfileMapper;
import nl.novi.beeindopdracht.mappers.UserMapper;
import nl.novi.beeindopdracht.repositories.UserRepository;
import nl.novi.beeindopdracht.utils.RandomStringGenerator;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    GET
    public List<User> getUsers() {
       return userRepository.findAll();
    }

    public User getUser(String username) {
        return userRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public boolean userExists(String username) {
        return userRepository.existsById(username);
    }

//    POST
    public String addUser(User user) {
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        user.setApiKey(randomString);
        User newUser = userRepository.save(user);
        return newUser.getUsername();
    }

    public String addAdmin(User user) {
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        user.setApiKey(randomString);
        User newUser = userRepository.save(user);
        return newUser.getUsername();
    }

//    DELETE
    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

//    public void updateUser(String username, UserDto newUser) {
//        if (!userRepository.existsById(username)) throw new RecordNotFoundException();
//        User user = userRepository.findById(username).get();
//        user.setPassword(newUser.getPassword());
//        userRepository.save(user);
//    }

//    public Set<Role> getRoles(String username) {
//        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
//        User user = userRepository.findById(username).get();
//        UserDto userDto = fromUser(user);
//        return userDto.getRoles();
//    }

    public void addRole(String username, String roleName) {

        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        user.addRole(new Role(username, roleName));
        userRepository.save(user);
    }

//    public void removeRole(String username, String role) {
//        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
//        User user = userRepository.findById(username).get();
//        Role roleToRemove = user.getRoles().stream().filter((a) -> a.getRole().equalsIgnoreCase(role)).findAny().get();
//        user.removeRole(roleToRemove);
//        userRepository.save(user);
//    }

}

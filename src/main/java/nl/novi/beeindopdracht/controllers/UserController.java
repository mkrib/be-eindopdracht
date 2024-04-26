package nl.novi.beeindopdracht.controllers;

import nl.novi.beeindopdracht.dtos.UserDto;
import nl.novi.beeindopdracht.entities.User;
import nl.novi.beeindopdracht.mappers.UserMapper;
import nl.novi.beeindopdracht.services.UserService;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<UserDto>> getUsers() {
        List<User> users = userService.getUsers();
        List<UserDto> userDtos = userMapper.translateToDtos(users);

        return ResponseEntity.ok().body(userDtos);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable("username") String username) {

        return ResponseEntity.ok(userService.getUser(username));
    }

    @PostMapping("")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto dto) {;
        String newUsername = userService.addUser(userMapper.translateToUser(dto));
        userService.addRole(newUsername, "ROLE_USER");

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newUsername).toUri();

        return ResponseEntity.created(location).build();
    }

//    @PutMapping("/{username}")
//    public ResponseEntity<UserDto> updateUser(@PathVariable("username") String username, @RequestBody UserDto dto) {
//
//        userService.updateUser(username, dto);
//
//        return ResponseEntity.noContent().build();
//    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Object> deleteUser(@PathVariable("username") String username) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

//    GET
//    @GetMapping("/{username}/roles")
//    public ResponseEntity<Object> getUserRoles(@PathVariable("username") String username) {
//        return ResponseEntity.ok().body(userService.getRoles(username));
//    }
//
//    @PostMapping("/{username}/roles")
//    public ResponseEntity<Object> addUserRoles(@PathVariable("username") String username, @RequestBody Map<String, Object> fields) throws BadRequestException {
//        try {
//            String roleName = (String) fields.get("role");
//            userService.addRole(username, roleName);
//            return ResponseEntity.noContent().build();
//        }
//        catch (Exception ex) {
//            throw new BadRequestException();
//        }
//    }
//
//    @DeleteMapping("/{username}/roles/{role}")
//    public ResponseEntity<Object> deleteUserRole(@PathVariable("username") String username, @PathVariable("role") String role) {
//        userService.removeRole(username, role);
//        return ResponseEntity.noContent().build();
//    }
}

package nl.novi.beeindopdracht.mappers;

import nl.novi.beeindopdracht.dtos.UserDto;
import nl.novi.beeindopdracht.entities.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {
    private final PasswordEncoder passwordEncoder;

    public UserMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public static UserDto translateToDto(User user){
        UserDto dto = new UserDto();

        dto.username = user.getUsername();
        dto.password = user.getPassword();
        dto.apiKey = user.getApiKey();

        return dto;
    }

    public List<UserDto> translateToDtos(List<User> usersList) {
        List<UserDto> result = new ArrayList<>();
        for (User user : usersList) {
            result.add(translateToDto(user));
        }
        return result;
    }

    public User translateToUser(UserDto dto) {

        var user = new User();

        user.setUsername(dto.getUsername());

        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        user.setPassword(encodedPassword);

        user.setApiKey(dto.getApiKey());

        return user;
    }
}

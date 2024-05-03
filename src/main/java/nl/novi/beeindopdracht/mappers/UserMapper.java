package nl.novi.beeindopdracht.mappers;

import nl.novi.beeindopdracht.dtos.UserDto;
import nl.novi.beeindopdracht.dtos.UserRequestDto;
import nl.novi.beeindopdracht.entities.Profile;
import nl.novi.beeindopdracht.entities.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {
    private final PasswordEncoder passwordEncoder;
    private final ProfileMapper profileMapper;

    public UserMapper(PasswordEncoder passwordEncoder, ProfileMapper profileMapper) {
        this.passwordEncoder = passwordEncoder;
        this.profileMapper = profileMapper;
    }

    public UserDto translateToUserDto(User user){
        UserDto dto = new UserDto();

        dto.username = user.getUsername();
//        dto.password = user.getPassword();
        dto.apiKey = user.getApiKey();
        dto.roles = user.getRoles();
        dto.reservations = user.getReservations();
        dto.reviews = user.getReviews();
        dto.blogposts = user.getBlogposts();

        if (user.getProfile() != null) {
            dto.profile = profileMapper.translateToDto(user.getProfile());
        }

        return dto;
    }

    public List<UserDto> translateToDtos(List<User> usersList) {
        List<UserDto> result = new ArrayList<>();
        for (User user : usersList) {
            result.add(translateToUserDto(user));
        }
        return result;
    }

    public User translateToUser(UserRequestDto dto) {

        var user = new User();

        user.setUsername(dto.getUsername());

        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        user.setPassword(encodedPassword);

        user.setApiKey(dto.getApiKey());

        return user;
    }

    public Profile translateToProfile(UserRequestDto dto) {
        Profile profile = new Profile();
        profile.setEmail(dto.getEmail());
        profile.setFirstname(dto.getFirstname());
        profile.setLastname(dto.getLastname());
        profile.setPhoneNumber(dto.getPhoneNumber());
        profile.setDateOfBirth(dto.getDateOfBirth());

        return profile;
    }
}

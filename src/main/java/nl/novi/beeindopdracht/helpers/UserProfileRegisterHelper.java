package nl.novi.beeindopdracht.helpers;

import nl.novi.beeindopdracht.dtos.UserRequestDto;
import nl.novi.beeindopdracht.entities.Profile;
import nl.novi.beeindopdracht.entities.User;
import nl.novi.beeindopdracht.mappers.UserMapper;
import nl.novi.beeindopdracht.repositories.ProfileRepository;
import org.springframework.stereotype.Component;

@Component
public class UserProfileRegisterHelper {

    private final ProfileRepository profileRepository;
    private final UserMapper userMapper;

    public UserProfileRegisterHelper(ProfileRepository profileRepository, UserMapper userMapper) {
        this.profileRepository = profileRepository;
        this.userMapper = userMapper;
    }

    public User createUserFromDto(UserRequestDto dto) {
        User newUser = userMapper.translateToUser(dto);
        Profile newProfile = userMapper.translateToProfile(dto);

        newUser.setProfile(profileRepository.save(newProfile));

        return newUser;
    }
}

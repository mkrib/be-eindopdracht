package nl.novi.beeindopdracht.mappers;

import nl.novi.beeindopdracht.dtos.ProfileDto;
import nl.novi.beeindopdracht.dtos.ProfileRequestDto;
import nl.novi.beeindopdracht.entities.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProfileMapper {

    //    Mapper om het profiel om te zetten naar een dto, die we willen teruggeven aan de gebruiker
    public ProfileDto translateToDto(Profile profile)
    {
        ProfileDto dto = new ProfileDto();
        dto.setId(profile.getId());
        dto.setEmail(profile.getEmail());
        dto.setFirstname(profile.getFirstname());
        dto.setLastname(profile.getLastname());
        dto.setPhoneNumber(profile.getPhoneNumber());
        dto.setDateOfBirth(profile.getDateOfBirth());

        return dto;
    }

    public List<ProfileDto> translateToDtos(List<Profile> profilesList) {
        List<ProfileDto> result = new ArrayList<>();
        for (Profile profile : profilesList) {
            result.add(translateToDto(profile));
        }
        return result;
    }

    //    Mapper om het request profiel om te zetten naar een profiel voor in de db
    public Profile translateToProfile(ProfileRequestDto dto) {
        Profile profile = new Profile();

        profile.setEmail(dto.getEmail());
        profile.setFirstname(dto.getFirstname());
        profile.setPhoneNumber(dto.getPhoneNumber());
        profile.setDateOfBirth(dto.getDateOfBirth());

        return profile;
    }
}

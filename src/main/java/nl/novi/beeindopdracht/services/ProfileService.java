package nl.novi.beeindopdracht.services;

import nl.novi.beeindopdracht.entities.Profile;
import nl.novi.beeindopdracht.entities.Review;
import nl.novi.beeindopdracht.exceptions.RecordNotFoundException;
import nl.novi.beeindopdracht.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    //    GET
    public List<Profile> getProfiles() {
        return profileRepository.findAll();
    }

    public Profile getProfile(Long id) {
        return profileRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Profile details not found"));
    }

    //    POST
    public Profile addProfile(Profile profile) {
        profileRepository.save(profile);
        return profile;
    }

    //    DELETE
    public void deleteProfileById(Long id) {
        profileRepository.deleteById(id);
    }
}

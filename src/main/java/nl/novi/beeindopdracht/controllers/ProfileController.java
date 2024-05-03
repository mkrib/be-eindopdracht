package nl.novi.beeindopdracht.controllers;

import jakarta.validation.Valid;
import nl.novi.beeindopdracht.dtos.ProfileDto;
import nl.novi.beeindopdracht.dtos.ProfileRequestDto;
import nl.novi.beeindopdracht.entities.Profile;
import nl.novi.beeindopdracht.mappers.ProfileMapper;
import nl.novi.beeindopdracht.services.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
    private final ProfileService profileService;
    private final ProfileMapper profileMapper;

    public ProfileController(ProfileService profileService, ProfileMapper profileMapper) {
        this.profileService = profileService;
        this.profileMapper = profileMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<ProfileDto>> getProfiles() {
        List<Profile> profiles = profileService.getProfiles();
        List<ProfileDto> profileDtos = profileMapper.translateToDtos(profiles);

        return ResponseEntity.ok().body(profileDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDto> getProfile(@PathVariable Long id) {
        Profile profile = profileService.getProfile(id);
        ProfileDto profileDto = profileMapper.translateToDto(profile);
        return ResponseEntity.ok().body(profileDto);
    }

    @PostMapping("")
    public ResponseEntity<ProfileDto> addProfile(@Valid @RequestBody ProfileRequestDto profileRequestDto) {
        Profile postedProfile = profileService.addProfile(profileMapper.translateToProfile(profileRequestDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(profileMapper.translateToDto(postedProfile));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProfile(@PathVariable Long id) {
        profileService.deleteProfileById(id);
        return ResponseEntity.noContent().build();
    }

}

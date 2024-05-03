package nl.novi.beeindopdracht.dtos;

import java.util.Date;

public class UserRequestDto {
    public String username;
    public String password;
    public String apiKey;
    public ProfileRequestDto profile;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public ProfileRequestDto getProfile() {
        return profile;
    }

    public void setProfile(ProfileRequestDto profile) {
        this.profile = profile;
    }

    public String getEmail() {
        return profile != null ? profile.getEmail() : null;
    }

    public void setEmail(String email) {
        if (profile == null) {
            profile = new ProfileRequestDto();
        }
        profile.setEmail(email);
    }

    public String getFirstname() {
        return profile != null ? profile.getFirstname() : null;
    }

    public void setFirstname(String firstname) {
        if (profile == null) {
            profile = new ProfileRequestDto();
        }
        profile.setFirstname(firstname);
    }

    public String getLastname() {
        return profile != null ? profile.getLastname() : null;
    }

    public void setLastname(String lastname) {
        if (profile == null) {
            profile = new ProfileRequestDto();
        }
        profile.setLastname(lastname);
    }

    public Long getPhoneNumber() {
        return profile != null ? profile.getPhoneNumber() : null;
    }

    public void setPhoneNumber(Long phoneNumber) {
        if (profile == null) {
            profile = new ProfileRequestDto();
        }
        profile.setPhoneNumber(phoneNumber);
    }

    public Date getDateOfBirth() {
        return profile != null ? profile.getDateOfBirth() : null;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        if (profile == null) {
            profile = new ProfileRequestDto();
        }
        profile.setDateOfBirth(dateOfBirth);
    }
}

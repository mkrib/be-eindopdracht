package nl.novi.beeindopdracht.dtos;

import jakarta.validation.constraints.NotNull;
import nl.novi.beeindopdracht.entities.User;

import java.util.Date;

public class ProfileRequestDto {
    @NotNull(message = "Email is required")
    private String email;
    @NotNull(message = "Name is required")
    private String fullName;
    private Long phoneNumber;
    private Date dateOfBirth;

    public ProfileRequestDto() {
    }

    public ProfileRequestDto(String email, String fullName, Long phoneNumber, Date dateOfBirth) {
        this.email = email;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}

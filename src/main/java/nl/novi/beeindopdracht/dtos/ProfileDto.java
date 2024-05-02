package nl.novi.beeindopdracht.dtos;

import nl.novi.beeindopdracht.entities.User;

import java.util.Date;

public class ProfileDto {
    private Long id;
    private String email;
    private String fullName;
    private Long phoneNumber;
    private Date dateOfBirth;

    public ProfileDto() {
    }

    public ProfileDto(Long id, String email, String fullName, Long phoneNumber, Date dateOfBirth) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

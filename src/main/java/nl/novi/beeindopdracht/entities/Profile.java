package nl.novi.beeindopdracht.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table
public class Profile {
    private String fullName;
    private String email;
    private Long phoneNumber;
    private Date dateOfBirth;
}

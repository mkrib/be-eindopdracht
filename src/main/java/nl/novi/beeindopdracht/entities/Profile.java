package nl.novi.beeindopdracht.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    TODO email unique maken
    private String email;
    private String fullName;
    private Long phoneNumber;
    private Date dateOfBirth;
}

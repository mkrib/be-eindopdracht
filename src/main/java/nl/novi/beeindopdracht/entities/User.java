package nl.novi.beeindopdracht.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    private String username;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;
}

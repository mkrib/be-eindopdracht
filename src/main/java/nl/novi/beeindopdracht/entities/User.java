package nl.novi.beeindopdracht.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    private String username;
    private String password;
//    @OneToMany(mappedBy = "user")
//    private List<Reservation> reservations;
}

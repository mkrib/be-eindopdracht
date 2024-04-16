package nl.novi.beeindopdracht.entities;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Time startTime;
    private Time endTime;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private Integer amountOfGuests;
    private String type;
    private String requestMessage;
//    @ManyToOne (fetch = FetchType.EAGER)
//    @JoinColumn(name = "username")
//    private User user;
}

package nl.novi.beeindopdracht.entities;

import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalTime startTime;
    private LocalTime endTime;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private Integer amountOfGuests;
    private String type;
    private String requestMessage;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private User user;

    public Reservation() {
    }

    public Reservation(Long id, LocalTime startTime, LocalTime endTime, LocalDate date, Integer amountOfGuests, String type, String requestMessage, User user) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.amountOfGuests = amountOfGuests;
        this.type = type;
        this.requestMessage = requestMessage;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getAmountOfGuests() {
        return amountOfGuests;
    }

    public void setAmountOfGuests(Integer amountOfGuests) {
        this.amountOfGuests = amountOfGuests;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRequestMessage() {
        return requestMessage;
    }

    public void setRequestMessage(String requestMessage) {
        this.requestMessage = requestMessage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

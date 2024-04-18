package nl.novi.beeindopdracht.dtos;

import nl.novi.beeindopdracht.entities.User;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationDto {
    private Long id;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate date;
    private Integer amountOfGuests;
    private String type;
    private String specialRequest;
//    TODO dubbel checken of ik deze user hier wel in wil hebben
//    private User user;

    public ReservationDto() {
    }

    public ReservationDto(Long id, LocalTime startTime, LocalTime endTime, LocalDate date, Integer amountOfGuests, String type, String specialRequest) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.amountOfGuests = amountOfGuests;
        this.type = type;
        this.specialRequest = specialRequest;
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

    public String getSpecialRequest() {
        return specialRequest;
    }

    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

}

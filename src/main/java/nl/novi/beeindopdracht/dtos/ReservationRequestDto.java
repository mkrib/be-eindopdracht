package nl.novi.beeindopdracht.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import nl.novi.beeindopdracht.entities.User;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationRequestDto {
    @NotNull(message = "The starting time of the reservation is required")
    private LocalTime startTime;
    private LocalTime endTime;
    @NotNull(message = "The date of the reservation is required")
    private LocalDate date;
    @NotNull(message = "The amount of guests of the reservation is required")
//    @Size(max = 6, message = "The amount of guests must be between 0-6")
    @Range(max = 6, message = "The amount of guests must be between 0-6")
    private Integer amountOfGuests;
    private String type;
    private String requestMessage;
    private User user;

    public ReservationRequestDto(LocalTime startTime, LocalTime endTime, LocalDate date, Integer amountOfGuests, String type, String requestMessage, User user) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.amountOfGuests = amountOfGuests;
        this.type = type;
        this.requestMessage = requestMessage;
        this.user = user;
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

package nl.novi.beeindopdracht.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Time;
import java.util.Date;

@Entity
@Table
public class Reservation {
    private Long id;
    private Time startTime;
    private Time endTime;
    private Date date;
    private String type;
    private String requestMessage;
}
